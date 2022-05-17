package com.deezer.artist;

import com.deezer.artist.mapper.response.ArtistEntityResponseMapper;
import com.deezer.artist.model.response.ArtistServiceResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ArtistServiceFacade {
    private final ArtistService artistService;

    public ArtistServiceResponse findArtist(String id) {
        return artistService.findArtistById(id)
                .map(ArtistEntityResponseMapper::toArtistEntity)
                .orElseGet(() -> artistService.findArtistIntegration(id));
    }

    public void deleteArtist(String id) {
        artistService.deleteArtist(id);
    }
}
