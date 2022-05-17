package com.deezer.artist.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ArtistIntegrationResponse {
    private String name;
    private String id;
    private String link;
    private String share;
    private String picture;
    @JsonProperty("nb_album")
    private Integer nbAlbum;
    @JsonProperty("nb_fan")
    private Integer nbFan;
    private String tracklist;
    private String type;
}
