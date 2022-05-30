package com.deezer.track.trackintegrationstub;

import com.deezer.track.model.response.TrackIntegrationResponse;

public class TrackIntegrationStub {
    public static TrackIntegrationResponse trackIntegrationExpectStub(){
        return TrackIntegrationResponse.builder()
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
