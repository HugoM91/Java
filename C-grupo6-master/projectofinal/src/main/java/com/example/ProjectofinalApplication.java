package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Repository;


@ComponentScan("com.example")
@Repository("com.example.repositories")
@EntityScan("com.example.entity")
@SpringBootApplication()
public class ProjectofinalApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjectofinalApplication.class, args);
    }

}
