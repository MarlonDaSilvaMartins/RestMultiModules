package com.deezer.artist.mapper.response;

import com.deezer.artist.model.response.ArtistIntegrationResponse;
import com.deezer.repository.entity.ArtistEntity;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ArtistIntegrationResponseMapper {
    public static ArtistEntity toIntegrationResponse(ArtistIntegrationResponse artistIntegrationResponse) {
        return ArtistEntity.builder()
                .id(artistIntegrationResponse.getId())
                .name(artistIntegrationResponse.getName())
                .link(artistIntegrationResponse.getLink())
                .share(artistIntegrationResponse.getShare())
                .picture(artistIntegrationResponse.getPicture())
                .nbAlbum(artistIntegrationResponse.getNbAlbum())
                .nbFan(artistIntegrationResponse.getNbFan())
                .tracklist(artistIntegrationResponse.getTracklist())
                .type(artistIntegrationResponse.getType())
                .build();
    }
}
