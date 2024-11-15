package com.example.todoappdevelop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class TodoAppDevelopApplication {

    public static void main(String[] args) {
        SpringApplication.run(TodoAppDevelopApplication.class, args);
    }

}
