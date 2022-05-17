package com.deezer.artist;

import com.deezer.artist.mapper.response.ArtistControllerResponseMapper;
import com.deezer.artist.model.response.ArtistControllerResponse;
import com.deezer.exceptions.datanotfound.DataNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

@Component
@AllArgsConstructor
public class ArtistControllerFacade {
    private final ArtistServiceFacade artistServiceFacade;

    public ArtistControllerResponse findArtist(String artist){
        return Stream.of(artistServiceFacade.findArtist(artist))
                .map(ArtistControllerResponseMapper::toControllerResponse)
                .findFirst()
                .orElseThrow(() -> new DataNotFoundException("Not Found"));
    }

    public void deleteArtist(String id){
        artistServiceFacade.deleteArtist(id);
    }
}
