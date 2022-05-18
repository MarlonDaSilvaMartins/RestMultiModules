package com.deezer.track.mapper.response;

import com.deezer.track.model.response.TrackIntegrationResponse;
import com.deezer.track.model.response.TrackServiceResponse;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TrackIntegrationResponseMapper {
    public static TrackServiceResponse toServiceResponse(TrackIntegrationResponse trackIntegrationResponse){
        return TrackServiceResponse.builder()
                .id(trackIntegrationResponse.getId())
                .url(trackIntegrationResponse.getUrl())
                .subtitle(trackIntegrationResponse.getSubtitle())
                .type(trackIntegrationResponse.getType())
                .title(trackIntegrationResponse.getTitle())
                .build();
    }
}
