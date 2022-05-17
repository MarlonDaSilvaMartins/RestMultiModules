package com.deezer.artist.mapper.response;

import com.deezer.artist.model.response.ArtistServiceResponse;
import com.deezer.repository.entity.ArtistEntity;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ArtistEntityResponseMapper {
    public static ArtistServiceResponse toArtistEntity(ArtistEntity artistEntity){
        return ArtistServiceResponse.builder()
                .id(artistEntity.getId())
                .name(artistEntity.getName())
                .link(artistEntity.getLink())
                .share(artistEntity.getShare())
                .picture(artistEntity.getPicture())
                .nbAlbum(artistEntity.getNbAlbum())
                .nbFan(artistEntity.getNbFan())
                .tracklist(artistEntity.getTracklist())
                .type(artistEntity.getType())
                .build();
    }
}
