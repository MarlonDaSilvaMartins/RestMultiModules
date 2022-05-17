package com.deezer.artist.model.response;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ArtistServiceResponse {
    private String name;
    private String id;
    private String link;
    private String share;
    private String picture;
    private Integer nbAlbum;
    private Integer nbFan;
    private String tracklist;
    private String type;
}
