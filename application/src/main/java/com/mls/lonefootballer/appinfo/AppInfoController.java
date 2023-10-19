package com.mls.lonefootballer.appinfo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Properties;

@RestController
@RequestMapping("/info")
public class AppInfoController {

    private final AppInfoService appInfoService;

    public AppInfoController(AppInfoService appInfoService) {
        this.appInfoService = appInfoService;
    }

    @GetMapping(path = {"", "/"}    )
    public Properties mavenProps() {
        return appInfoService.getAppProperties();

    }

    @GetMapping(path = { "/{property-name}"}    )
    public String mavenProperty(@PathVariable("property-name") String propertyName) {
        return appInfoService.getAppProperties().getProperty(propertyName);

    }

}
