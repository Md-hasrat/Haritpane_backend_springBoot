package com.Haritpane.springBoot_haritpane_backend.config;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "aws")
public class AwsProperties {

    private String region;
    private String bucketName;
    private String accessKey;
    private String secretKey;
}