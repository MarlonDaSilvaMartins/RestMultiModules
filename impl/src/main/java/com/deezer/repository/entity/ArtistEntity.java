package com.deezer.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Document("Deezer")
public class ArtistEntity {
    @Id
    private String id;
    private String name;
    private String link;
    private String share;
    private String picture;
    private Integer nbAlbum;
    private Integer nbFan;
    private String tracklist;
    private String type;
}
