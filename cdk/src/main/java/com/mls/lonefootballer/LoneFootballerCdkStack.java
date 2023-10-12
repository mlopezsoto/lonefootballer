package com.mls.lonefootballer;

import software.amazon.awscdk.CfnOutput;
import software.amazon.awscdk.Stack;
import software.amazon.awscdk.StackProps;
import software.amazon.awscdk.services.dynamodb.*;
import software.constructs.Construct;

import java.util.List;

public class LoneFootballerCdkStack extends Stack {

    public LoneFootballerCdkStack(final Construct parent, final String id, final StackProps props) {
        super(parent, id, props);
        buildDynamoDbTable();

    }

    private void buildDynamoDbTable() {
        var tableName = "LoneFootballer";

        TableV2 table = TableV2.Builder.create(this, tableName)
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
