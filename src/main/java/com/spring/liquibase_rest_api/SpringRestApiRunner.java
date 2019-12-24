package com.spring.liquibase_rest_api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.spring.liquibase_rest_api" )
public class SpringRestApiRunner {

    public static void main(String... args){
        SpringApplication.run(SpringRestApiRunner.class);
    }
}
