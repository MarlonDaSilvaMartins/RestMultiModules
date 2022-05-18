package com.deezer.track;

import com.deezer.track.model.response.TrackServiceResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class TrackServiceFacade {
    private final TrackService trackService;
    public TrackServiceResponse findTrack(String trackId){
        return trackService.findTrack(trackId);
    }
}
