# CDK Java project to manage LoneFootballer AWS Infrastructure

The `cdk.json` file tells the CDK Toolkit how to execute your app.

It is a [Maven](https://maven.apache.org/) based project, so you can open this project with any Maven compatible Java IDE to build and run tests.

## Useful commands

 * `mvn package`     compile and run tests
 * `cdk ls`          list all stacks in the app
 * `cdk synth`       emits the synthesized CloudFormation template
 * `cdk deploy`      deploy this stack to your default AWS account/region
 * `cdk diff`        compare deployed stack with current state
 * `cdk docs`        open CDK documentation

###
To deploy updates to the code, create a ZIP or JAR file using maven on the application project, then run cdk deploy again. 
CDK is smart enough to detect changes in the ZIP or JAR file and will upload the new code to the Lambda function.