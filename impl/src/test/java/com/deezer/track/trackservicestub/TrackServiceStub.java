package com.deezer.track.trackservicestub;

import com.deezer.track.model.response.TrackIntegrationResponse;
import com.deezer.track.model.response.TrackServiceResponse;

public class TrackServiceStub {
    public static TrackServiceResponse trackServiceExpectedStub(){
        return TrackServiceResponse.builder()
                .id("54428397")
                .url("https://www.shazam.com/track/54428397/without-me")
                .subtitle("Eminem")
                .type("MUSIC")
                .title("Without Me")
                .build();
    }

    public static TrackIntegrationResponse trackIntegrationStub(){
        return TrackIntegrationResponse.builder()
                .id("54428397")
                .url("https://www.shazam.com/track/54428397/without-me")
                .subtitle("Eminem")
                .type("MUSIC")
                .title("Without Me")
                .build();
    }
}
