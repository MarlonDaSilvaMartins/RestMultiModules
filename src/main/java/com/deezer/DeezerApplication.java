package com.deezer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@SpringBootApplication
public class DeezerApplication {

    public static void main(String[] args) {
        SpringApplication.run(DeezerApplication.class, args);
    }

}
