package com.mls.lonefootballer.player;

import com.mls.lonefootballer.data.DynamoDbProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;

@Configuration
public class PlayerConfig {

    @Bean
    public PlayerService userService(PlayerRepository playerRepository) {
        return new PlayerServiceImpl(playerRepository);
    }

    @Bean
    public DynamoDbTable<PlayerEntity> playerEntityDynamoTable(DynamoDbEnhancedClient dynamoDbEnhancedClient, DynamoDbProperties dynamoDbProperties) {
       return dynamoDbEnhancedClient.table(dynamoDbProperties.getTableName(), TableSchema.fromBean(PlayerEntity.class));
    }
}
