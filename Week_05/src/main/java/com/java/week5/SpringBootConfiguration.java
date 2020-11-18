package com.java.week5;


import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.java.week5.starter")
//@EnableConfigurationProperties(SpringBootProperiesConfiguration.class)
@ConditionalOnProperty(prefix = "spring.bean", name = "enabled", havingValue = "true",matchIfMissing = true)
public class SpringBootConfiguration {

    static{
        System.out.println("hello");
    }

}
