package com.mls.lonefootballer.appinfo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration
public class AppInfoConfig {

    @Bean
    public AppInfoService appInfoService() throws IOException {
        return new AppInfoServiceImpl();
    }

}
