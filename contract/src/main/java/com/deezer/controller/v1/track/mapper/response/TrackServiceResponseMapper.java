package com.deezer.controller.v1.track.mapper.response;

import com.deezer.controller.v1.track.model.response.TrackControllerResponse;
import com.deezer.track.model.response.TrackServiceResponse;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TrackServiceResponseMapper {
    public static TrackControllerResponse toControllerResponse(TrackServiceResponse trackServiceResponse){
        return TrackControllerResponse.builder()
                .id(trackServiceResponse.getId())
                .url(trackServiceResponse.getUrl())
                .subtitle(trackServiceResponse.getSubtitle())
                .type(trackServiceResponse.getType())
                .title(trackServiceResponse.getTitle())
                .build();
    }
}
