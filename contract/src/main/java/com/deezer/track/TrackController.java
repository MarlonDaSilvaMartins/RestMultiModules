package com.deezer.track;

import com.deezer.track.model.response.TrackControllerResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("v1/track")
public class TrackController {

    TrackControllerFacade trackControllerFacade;

    @GetMapping("/{trackId}")
    public TrackControllerResponse findArtist(@PathVariable String trackId){
        return trackControllerFacade.findTrack(trackId);
    }
}
