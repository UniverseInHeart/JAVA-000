package com.java.week5;


import com.java.week5.inject.bean.Student;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.java.week5.starter")
//@EnableConfigurationProperties(SpringBootProperiesConfiguration.class)
@ConditionalOnProperty(prefix = "spring.bean", name = "enabled", havingValue = "true", matchIfMissing = true)
public class SpringBootConfiguration {

    static {
        System.out.println("hello");
    }

    @Bean(name = "starter_one")
    public Student createOne() {
        return new Student(100, "starter1");
    }

    @Bean(name = "starter_two")
    public Student createTwo() {
        return new Student(200, "starter2");
    }

}
