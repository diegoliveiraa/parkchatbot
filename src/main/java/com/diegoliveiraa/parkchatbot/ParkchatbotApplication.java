package com.diegoliveiraa.parkchatbot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ParkchatbotApplication {

    public static void main(String[] args) {
        SpringApplication.run(ParkchatbotApplication.class, args);
    }

}
