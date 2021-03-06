package com.deezer.controller.v1.track.trackcontrollerstub;

import com.deezer.controller.v1.track.model.response.TrackControllerResponse;
import com.deezer.track.model.response.TrackServiceResponse;

public class TrackControllerFacadeStub {
    public static TrackControllerResponse trackControllerExpectedStub(){
        return TrackControllerResponse.builder()
                .id("54428397")
                .url("https://www.shazam.com/track/54428397/without-me")
                .subtitle("Eminem")
                .type("MUSIC")
                .title("Without Me")
                .build();
    }

    public static TrackServiceResponse trackServiceStub(){
        return TrackServiceResponse.builder()
                .id("54428397")
                .url("https://www.shazam.com/track/54428397/without-me")
                .subtitle("Eminem")
                .type("MUSIC")
                .title("Without Me")
                .build();
    }
}
