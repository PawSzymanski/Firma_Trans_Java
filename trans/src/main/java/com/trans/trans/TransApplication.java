package com.trans.trans;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties
@SpringBootApplication
public class TransApplication {

    public static void main(String[] args) {
        SpringApplication.run(TransApplication.class, args);
    }

}
