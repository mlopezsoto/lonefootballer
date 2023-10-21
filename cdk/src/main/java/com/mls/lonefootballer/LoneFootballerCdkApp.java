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
                        .build())
                .build();

        new LoneFootballerCdkStack(app, stackId, props);

        app.synth();
    }
}
