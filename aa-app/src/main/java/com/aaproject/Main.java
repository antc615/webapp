package com.aaproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Properties;

@SpringBootApplication
@EnableAutoConfiguration
public class Main {
    public static void main(String args[]) {
        SpringApplication app = new SpringApplication(Main.class);

        Properties properties = new Properties();
        properties.setProperty("spring.resources.static-locations",
                "classpath:/static/customers.html, classpath:/static/profile.html, classpath:/static/index.html");
        app.setDefaultProperties(properties);

        app.run(Main.class, args);
    }
}
