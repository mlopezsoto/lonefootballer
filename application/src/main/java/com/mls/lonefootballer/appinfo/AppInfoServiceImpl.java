package com.mls.lonefootballer.appinfo;

import java.io.IOException;
import java.util.Properties;

public class AppInfoServiceImpl implements AppInfoService {

    private final Properties appProperties;

    public AppInfoServiceImpl() throws IOException {
        appProperties = new Properties();
        appProperties.load(getClass().getResourceAsStream("/maven.properties"));
    }

    @Override
    public Properties getAppProperties() {
        return appProperties;
    }
}
