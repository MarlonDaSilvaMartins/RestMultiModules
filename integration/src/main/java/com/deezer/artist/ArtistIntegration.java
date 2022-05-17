package com.deezer.artist;

import com.deezer.artist.model.response.ArtistIntegrationResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@AllArgsConstructor
@Component
public class ArtistIntegration {
    private final RestTemplate restTemplate;

    public ArtistIntegrationResponse findArtist(String artist){
        return restTemplate.getForObject("/artist/".concat(artist), ArtistIntegrationResponse.class);
    }
}
