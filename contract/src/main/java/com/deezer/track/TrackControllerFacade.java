package com.deezer.track;

import com.deezer.track.model.response.TrackControllerResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import static com.deezer.track.mapper.response.TrackServiceResponseMapper.toControllerResponse;

@Component
@AllArgsConstructor
public class TrackControllerFacade {
    private final TrackServiceFacade trackServiceFacade;

    public TrackControllerResponse findTrack(String trackId){
        return toControllerResponse(trackServiceFacade.findTrack(trackId));
    }
}
