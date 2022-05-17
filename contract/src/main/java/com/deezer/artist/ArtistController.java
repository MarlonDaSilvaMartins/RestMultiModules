package com.deezer.artist;

import com.deezer.artist.model.response.ArtistControllerResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("v1/artist")
public class ArtistController {
    ArtistControllerFacade artistControllerFacade;

    @GetMapping("/{id}")
    public ArtistControllerResponse findArtist(@PathVariable String id){
        return artistControllerFacade.findArtist(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteArtist(@PathVariable String id){
        artistControllerFacade.deleteArtist(id);
    }
}
