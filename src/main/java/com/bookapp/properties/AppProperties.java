package com.bookapp.properties;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@EnableConfigurationProperties
@Configuration
public class AppProperties {
	Map<String, String> messages = new HashMap<>();

	public Map<String, String> getMessages() {
		return messages;
	}

}