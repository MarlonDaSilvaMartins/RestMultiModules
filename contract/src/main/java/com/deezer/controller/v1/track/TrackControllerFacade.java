package com.deezer.controller.v1.track;

import com.deezer.controller.v1.track.model.response.TrackControllerResponse;
import com.deezer.track.TrackServiceFacade;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import static com.deezer.controller.v1.track.mapper.response.TrackServiceResponseMapper.toControllerResponse;

@Component
@AllArgsConstructor
public class TrackControllerFacade {
    private final TrackServiceFacade trackServiceFacade;

    public TrackControllerResponse findTrack(String trackId){
        return toControllerResponse(trackServiceFacade.findTrack(trackId));
    }
}
