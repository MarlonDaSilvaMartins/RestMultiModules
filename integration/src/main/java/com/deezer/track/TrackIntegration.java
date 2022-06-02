package com.deezer.track;

import com.deezer.track.model.response.TrackIntegrationResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@AllArgsConstructor
@Component
public class TrackIntegration {
    private final RestTemplate shazamRestTemplate;

    public TrackIntegrationResponse findTrack(String track){
        return shazamRestTemplate.getForObject("/tracks/details?track_id=".concat(track), TrackIntegrationResponse.class);
    }
}
