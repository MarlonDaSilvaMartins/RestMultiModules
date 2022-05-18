package com.deezer.artist;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ContextConfiguration;

import static com.deezer.artist.servicestub.ArtistServiceFacadeStub.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@ExtendWith(MockitoExtension.class)
@ContextConfiguration(classes = {ArtistServiceFacade.class, ArtistService.class})
class ArtistServiceFacadeTest {
    @InjectMocks
    ArtistServiceFacade artistServiceFacade;

    @Mock
    ArtistService artistService;

    @Test
    void whenFindArtistReturnArtistService() {
        var expected = artistServiceResponseExpectedStub();
        var findByIdResponse = artistEntityOptionalStub();

        Mockito.when(artistService.findArtistById("13"))
                .thenReturn(findByIdResponse);

        var actual = artistServiceFacade.findArtist("13");
        assertEquals(expected, actual);

    }

    @Test
    void whenFindArtistByIntegrationReturnArtistService() {
        var expected = artistServiceResponseExpectedStub();
        var serviceResponse = artistServiceResponseStub();

        Mockito.when(artistService.findArtistIntegration("13"))
                .thenReturn(serviceResponse);

        var actual = artistServiceFacade.findArtist("13");
        assertEquals(expected, actual);

    }

    @Test
    void whenDeleteArtistReturnNothing() {
        Mockito.doNothing().when(artistService).deleteArtist("13");

        artistServiceFacade.deleteArtist("13");

        var actual = Mockito.verify(this.artistService, Mockito.atMostOnce()).findArtistById("13");

        assertNull(actual);
    }
}