package com.deezer.track;

import com.deezer.track.model.response.TrackControllerResponse;
import io.swagger.annotations.ApiOperation;
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

    @ApiOperation(value = "find track")
    @GetMapping("/{trackId}")
    public TrackControllerResponse findTrack(@PathVariable String trackId){
        return trackControllerFacade.findTrack(trackId);
    }
}
