package com.deezer.controller.v1.artist.mapper.response;

import com.deezer.controller.v1.artist.model.response.ArtistControllerResponse;
import com.deezer.artist.model.response.ArtistServiceResponse;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ArtistControllerResponseMapper {
    public static ArtistControllerResponse toControllerResponse(ArtistServiceResponse artistServiceResponse){
        return ArtistControllerResponse.builder()
                .id(artistServiceResponse.getId())
                .name(artistServiceResponse.getName())
                .link(artistServiceResponse.getLink())
                .share(artistServiceResponse.getShare())
                .picture(artistServiceResponse.getPicture())
                .nbAlbum(artistServiceResponse.getNbAlbum())
                .nbFan(artistServiceResponse.getNbFan())
                .tracklist(artistServiceResponse.getTracklist())
                .type(artistServiceResponse.getType())
                .build();
    }
}
