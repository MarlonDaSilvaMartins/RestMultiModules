package com.deezer.config;

import com.deezer.exceptions.trackhandler.TrackErrorHandler;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestConfiguration {
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplateBuilder()
                .rootUri("https://deezerdevs-deezer.p.rapidapi.com")
                .defaultHeader("X-RapidAPI-Host","deezerdevs-deezer.p.rapidapi.com")
                .defaultHeader("X-RapidAPI-Key","cbe4664fbamsh6ce4d0f7ffe04c9p1ba2cbjsn1f328399f35b")
                .build();
    }

    @Bean
    public RestTemplate shazamRestTemplate(){
        return new RestTemplateBuilder()
                .rootUri("https://shazam-core.p.rapidapi.com/v1")
                .defaultHeader("X-RapidAPI-Host","shazam-core.p.rapidapi.com")
                .defaultHeader("X-RapidAPI-Key","cbe4664fbamsh6ce4d0f7ffe04c9p1ba2cbjsn1f328399f35b")
                .errorHandler(new TrackErrorHandler())
                .build();
    }
}
