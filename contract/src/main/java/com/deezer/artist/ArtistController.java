package com.deezer.artist;

import com.deezer.artist.model.response.ArtistControllerResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping(value = "v1/artist")
@Api(value = "Artist")
public class ArtistController {
    ArtistControllerFacade artistControllerFacade;

    @GetMapping("/{id}")
    @ApiOperation(value = "find artist")
    public ArtistControllerResponse findArtist(@PathVariable String id){
        return artistControllerFacade.findArtist(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value = "delete artist")
    public void deleteArtist(@PathVariable String id){
        artistControllerFacade.deleteArtist(id);
    }
}
