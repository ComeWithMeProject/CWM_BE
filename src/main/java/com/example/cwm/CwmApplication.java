package com.example.cwm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class CwmApplication {

    public static void main(String[] args) {
        SpringApplication.run(CwmApplication.class, args);
    }

}
