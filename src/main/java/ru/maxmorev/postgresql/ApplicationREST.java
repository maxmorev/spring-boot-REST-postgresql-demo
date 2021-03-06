package ru.maxmorev.postgresql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ApplicationREST {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
