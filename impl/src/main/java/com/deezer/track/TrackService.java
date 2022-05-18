package com.deezer.track;

import com.deezer.track.model.response.TrackServiceResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import static com.deezer.track.mapper.response.TrackIntegrationResponseMapper.toServiceResponse;

@Service
@AllArgsConstructor
public class TrackService {
    private final TrackIntegration trackIntegration;

    public TrackServiceResponse findTrack(String trackId){
        return toServiceResponse(trackIntegration.findTrack(trackId));
    }
}
