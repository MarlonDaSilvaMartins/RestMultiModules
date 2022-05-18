package com.deezer.track;

import com.deezer.exceptions.trackhandler.TrackErrorHandler;
import com.deezer.track.model.response.TrackIntegrationResponse;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class TrackIntegration {
    RestTemplate restTemplate = new RestTemplateBuilder()
            .rootUri("https://deezerdevs-deezer.p.rapidapi.com/v1")
            .defaultHeader("X-RapidAPI-Host","shazam-core.p.rapidapi.com")
            .defaultHeader("X-RapidAPI-Key","cbe4664fbamsh6ce4d0f7ffe04c9p1ba2cbjsn1f328399f35b")
            .errorHandler(new TrackErrorHandler())
            .build();

    public TrackIntegrationResponse findTrack(String track){
        return restTemplate.getForObject("/tracks/details?track_id=".concat(track), TrackIntegrationResponse.class);
    }
}
