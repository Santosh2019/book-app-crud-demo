package com.bookapp.properties;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@EnableConfigurationProperties
@Configuration
public class AppProperties {
    Map<String, String> messages = new HashMap<>();

    public Map<String, String> getMessages() {
        return messages;
    }

}