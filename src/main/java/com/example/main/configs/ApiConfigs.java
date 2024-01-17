package com.example.main.configs;


import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "app-properties")
public class ApiConfigs {
    private String apiUsername;
    private String apiPassword;
}

