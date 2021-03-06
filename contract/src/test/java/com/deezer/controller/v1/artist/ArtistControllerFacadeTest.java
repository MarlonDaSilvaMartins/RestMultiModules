package com.deezer.controller.v1.artist;

import com.deezer.artist.ArtistServiceFacade;
import com.deezer.controller.v1.artist.artistcontrollerstub.ArtistControllerFacadeStub;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@ContextConfiguration(classes = {ArtistControllerFacade.class, ArtistServiceFacade.class})
class ArtistControllerFacadeTest {
    @InjectMocks
    ArtistControllerFacade artistControllerFacade;

    @Mock
    ArtistServiceFacade artistServiceFacade;

    @Test
    void findArtistReturnArtistController() {
        var expected = ArtistControllerFacadeStub.artistControllerResponseExpectedStub();
        var response = ArtistControllerFacadeStub.artistControllerResponseStub();

        when(artistServiceFacade.findArtist("13"))
                .thenReturn(response);

        var actual = artistControllerFacade.findArtist("13");
        assertEquals(expected, actual);
    }

    @Test
    void whenDeleteArtistReturnNothing() {
        doNothing().when(artistServiceFacade).deleteArtist("13");

        artistControllerFacade.deleteArtist("13");

        var actual = verify(this.artistServiceFacade, Mockito.atMostOnce()).findArtist("13");

        assertNull(actual);
    }
}