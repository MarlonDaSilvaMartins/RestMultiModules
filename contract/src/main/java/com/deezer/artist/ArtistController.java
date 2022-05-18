package com.deezer.artist;

import com.deezer.artist.model.response.ArtistControllerResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("v1/artist")
@Api(value = "Artist")
public class ArtistController {
    ArtistControllerFacade artistControllerFacade;

    @ApiOperation(value = "find artist")
    @GetMapping("/{id}")
    public ArtistControllerResponse findArtist(@PathVariable String id){
        return artistControllerFacade.findArtist(id);
    }

    @ApiOperation(value = "delete artist")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteArtist(@PathVariable String id){
        artistControllerFacade.deleteArtist(id);
    }
}
