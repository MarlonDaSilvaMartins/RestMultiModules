package com.deezer.artist;

import com.deezer.controller.v1.artist.ArtistControllerFacade;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ContextConfiguration;

import static com.deezer.artist.controllerstub.ArtistControllerFacadeStub.artistControllerResponseExpectedStub;
import static com.deezer.artist.controllerstub.ArtistControllerFacadeStub.artistControllerResponseStub;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@ExtendWith(MockitoExtension.class)
@ContextConfiguration(classes = {ArtistControllerFacade.class, ArtistServiceFacade.class})
class ArtistControllerFacadeTest {
    @InjectMocks
    ArtistControllerFacade artistControllerFacade;

    @Mock
    ArtistServiceFacade artistServiceFacade;

    @Test
    void findArtistReturnArtistController() {
        var expected = artistControllerResponseExpectedStub();
        var response = artistControllerResponseStub();

        Mockito.when(artistServiceFacade.findArtist("13"))
                .thenReturn(response);

        var actual = artistControllerFacade.findArtist("13");
        assertEquals(expected, actual);
    }

    @Test
    void whenDeleteArtistReturnNothing() {
        Mockito.doNothing().when(artistServiceFacade).deleteArtist("13");

        artistControllerFacade.deleteArtist("13");

        var actual = Mockito.verify(this.artistServiceFacade, Mockito.atMostOnce()).findArtist("13");

        assertNull(actual);
    }
}