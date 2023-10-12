package com.mls.lonefootballer;

import org.junit.jupiter.api.Test;
import software.amazon.awscdk.App;
import software.amazon.awscdk.assertions.Template;

import java.io.IOException;
import java.util.HashMap;

public class LoneFootballerCdkStackTest {

    @Test
    public void testStack() throws IOException {
        App app = new App();
        LoneFootballerCdkStack stack = new LoneFootballerCdkStack(app, "test", null);

        Template template = Template.fromStack(stack);

        template.hasResourceProperties("AWS::DynamoDB::GlobalTable", new HashMap<String, String>() {{
          put("BillingMode", "PAY_PER_REQUEST");
        }});

        template.resourceCountIs("AWS::DynamoDB::GlobalTable", 1);
    }
}
