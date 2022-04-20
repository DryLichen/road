package org.dry.bean;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "pet")
@Component
@Data
public class Pet {
    private String name;
    private Double weight;
}
