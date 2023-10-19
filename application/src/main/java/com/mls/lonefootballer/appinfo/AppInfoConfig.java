package com.mls.lonefootballer.appinfo;

import com.mls.lonefootballer.data.DynamoDbProperties;
import com.mls.lonefootballer.player.PlayerEntity;
import com.mls.lonefootballer.player.PlayerRepository;
import com.mls.lonefootballer.player.PlayerService;
import com.mls.lonefootballer.player.PlayerServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;

import java.io.IOException;

@Configuration
public class AppInfoConfig {

    @Bean
    public AppInfoService appInfoService() throws IOException {
        return new AppInfoServiceImpl();
    }

}
