package com.mls.lonefootballer;

import software.amazon.awscdk.CfnOutput;
import software.amazon.awscdk.Stack;
import software.amazon.awscdk.StackProps;
import software.amazon.awscdk.services.apigateway.*;
import software.amazon.awscdk.services.dynamodb.*;
import software.amazon.awscdk.services.lambda.Code;
import software.amazon.awscdk.services.lambda.Function;
import software.amazon.awscdk.services.lambda.Runtime;
import software.constructs.Construct;

import java.util.List;

import static software.amazon.awscdk.services.lambda.SnapStartConf.ON_PUBLISHED_VERSIONS;

public class LoneFootballerCdkStack extends Stack {

    public LoneFootballerCdkStack(final Construct parent, final String id, final StackProps props) {
        super(parent, id, props);

        buildDynamoDbTable();
        buildAndDeployLambda();

    }

    private void buildAndDeployLambda() {

        Function loneFootballerHandler = Function.Builder.create(this, "LoneFootballer-LambdaFunction")
                .functionName("LoneFootballer")
                .runtime(Runtime.JAVA_17)
                .code(Code.fromAsset("../application/target/lonefootballer-api-0.0.1-SNAPSHOT-lambda-package.zip"))
                .handler("com.mls.lonefootballer.StreamLambdaHandler::handleRequest")
                .snapStart(ON_PUBLISHED_VERSIONS)
                .build();

        // Publish a version of the Lambda function, needed for SnapStart. Invoking the below method creates a version.
        loneFootballerHandler.getCurrentVersion();

        RestApi api = RestApi.Builder.create(this, "LoneFootballer-API")
                .restApiName("LoneFootballer-API").description("Proxy to LoneFootballer Lambda API")
                .endpointTypes(List.of(EndpointType.REGIONAL))
                .cloudWatchRole(true)
                // Deployment to stage 'prod' is set by default. Below code
                .deployOptions(StageOptions.builder()
                        .loggingLevel(MethodLoggingLevel.INFO)
                        .dataTraceEnabled(true)
                        .stageName("dev")
                        .description("Dev stage")
                        .build())
                .build();

        LambdaIntegration loneFootballerLambdaIntegration = LambdaIntegration.Builder.create(loneFootballerHandler)
                .build();

        // Proxy
        api.getRoot().addProxy(ProxyResourceOptions.builder()
                .defaultIntegration(loneFootballerLambdaIntegration)
                // "false" will require explicitly adding methods on the `proxy` resource
                .anyMethod(true)
                .build());

        CfnOutput.Builder.create(this, "Invoke URL").value(api.getDeploymentStage().urlForPath());

    }

    private void buildDynamoDbTable() {
        var tableName = "LoneFootballer";

        TableV2 table = TableV2.Builder.create(this, tableName + "-DynamoDbTable")
                .tableName(tableName)
                .partitionKey(Attribute.builder()
                        .name("partition-key")
                        .type(AttributeType.STRING)
                        .build())
                .sortKey(Attribute.builder()
                        .name("sort-key")
                        .type(AttributeType.STRING)
                        .build())
                .globalSecondaryIndexes(List.of(GlobalSecondaryIndexPropsV2.builder()
                        .indexName("gsi")
                        .partitionKey(Attribute.builder()
                                .name("gsi-partition-key")
                                .type(AttributeType.STRING)
                                .build())
                        .sortKey(Attribute.builder()
                                .name("gsi-sort-key")
                                .type(AttributeType.STRING)
                                .build())
                        .projectionType(ProjectionType.ALL)
                        .build()))
                .billing(Billing.onDemand())
                .build();
        CfnOutput.Builder.create(this, "Table ID").value(table.getTableId()).build();

    }
}
