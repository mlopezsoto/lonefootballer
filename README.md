# Lone Footballer (Work in progress)

<img src="lonefootballer.jfif" alt="drawing" style="width:300px;"/>

This is an app to help young footballers with trials, training and other football related tasks and activities.

## Development
Tech stack: Java 17, Spring Boot 3, DynamoDB.
Infrastructure: AWS API Gateway, AWS Lambda, AWS DynamoDB.

Project is divided in two modules:
- application: REST API developed using Java 17, Spring Boot and AWS DynamoDB.
- sdk: This infrastructure-as-code app deploys the application to AWS. It uses API Gateway, AWS Lambda and DynamoDB.

### Deploy a Spring Boot app to AWS API Gateway and AWS Lambda
To deploy a Spring Boot 3 serverless we use [aws-serverless-java-container](https://github.com/awslabs/aws-serverless-java-container/wiki/Quick-start---Spring-Boot3) 

## Test it on AWS
This is easy to deploy and test using your own AWS Account.
1. Build the app using maven. Go to application folder and run: `>mvn clean package` This will create a zip file in your target directory.
2. Deploy to AWS. You will need a AWS account. To deploy to you aws account run:  `>cdk deploy`
At the end of the deployment, you will see the URL where your app is available, i.e. LoneFootballerCdk-Stack.LoneFootballerAPIEndpointFBD628AE = https://id123456.execute-api.ap-southeast-2.amazonaws.com/dev/

You can get create players using `POST <url>/players`

JSON Example to create a player:

`{
"firstName": "Pepe",
"lastName": "Washington",
"intro": "I am a great player.",
"email": "elpepe@example.com",
"addressCountry": "Australia",
"addressCity": "Sydney",
"addressState": "NSW",
"addressPostCode": "2000",
"phone": "123-456-7891",
"preferredPositions": "Forward",
"preferredFoot": "Right",
"lookingForTeam": true,
"birthDate": "2009-02-20",
"sex": "Male",
"currentTeam": "Muswellbrook Eagles",
"youTubeChannelUrl": "https://www.youtube.com/user/pepechannel"
}
`