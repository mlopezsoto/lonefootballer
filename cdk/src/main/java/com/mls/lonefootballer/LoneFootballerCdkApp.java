package com.mls.lonefootballer;

import software.amazon.awscdk.App;
import software.amazon.awscdk.Environment;
import software.amazon.awscdk.StackProps;

public final class LoneFootballerCdkApp {
    public static void main(final String[] args) {
        App app = new App();
        var stackId = "LoneFootballerCdk-Stack";

        StackProps props = StackProps.builder()
                .stackName(stackId)
                .description("Lone Footballer stack")
                .env(Environment.builder()
                        .account("845831624882")
                        .region("ap-southeast-2")
                        .build())
                .build();

        new LoneFootballerCdkStack(app, stackId, props);

        app.synth();
    }
}
