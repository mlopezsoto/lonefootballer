package com.mls.lonefootballer.data;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("lonefootballer.dynamo-db")
@Data
public class DynamoDbProperties {

    String tableName;

}
