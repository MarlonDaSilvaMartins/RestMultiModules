package com.deezer.artist;

import com.deezer.artist.model.response.ArtistIntegrationResponse;
import com.deezer.artist.model.response.ArtistServiceResponse;
import com.deezer.exceptions.datanotfound.DataNotFoundException;
import com.deezer.repository.ArtistRepository;
import com.deezer.repository.entity.ArtistEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ContextConfiguration;

import java.util.Optional;

import static com.deezer.artist.artistservicestub.ArtistServiceStub.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@ContextConfiguration(classes = {ArtistService.class, ArtistRepository.class, ArtistIntegration.class})
class ArtistServiceTest {

    @InjectMocks
    ArtistService artistService;

    @Mock
    ArtistRepository artistRepository;

    @Mock
    ArtistIntegration artistIntegration;

    @Test
    void whenFindArtistByIdReturnOptionalOfArtistEntity() {
        Optional<ArtistEntity> entityResponse = artistEntityOptionalStub();
        Optional<ArtistEntity> entityExpected = artistOptionalExpectedStub();

        when(artistRepository.findById("13"))
                .thenReturn(entityResponse);

        var actual = artistService.findArtistById("13");
        assertEquals(entityExpected, actual);
    }

    @Test
    void whenFindArtistIntegrationReturnArtistServiceResponse() {
        ArtistServiceResponse responseExpected = artistServiceResponseExpectedStub();
        ArtistEntity entityEntity = artistEntityStub();
        ArtistIntegrationResponse integrationResponse = artistIntegrationResponseStub();

        when(artistIntegration.findArtist("13")).thenReturn(integrationResponse);
        when(artistRepository.save(entityEntity)).thenReturn(entityEntity);

        var actual = artistService.findArtistIntegration("13");

        assertEquals(responseExpected, actual);
    }

    @Test
    void whenNotFindArtistIntegrationReturnBadRequest() {
        ArtistIntegrationResponse integrationResponse = artistIntegrationNotFoundStub();

        when(artistIntegration.findArtist("13r")).thenReturn(integrationResponse);


        Exception exception = assertThrows(DataNotFoundException.class,
                () -> artistService.findArtistIntegration("13r"));

        var expected = "id";

        var actual = exception.getMessage();

        assertEquals(actual, expected);
    }

    @Test
    void whenDeleteArtistReturnNothing() {
        doNothing().when(artistRepository).deleteById("13");

        artistService.deleteArtist("13");

        verify(this.artistRepository, Mockito.atMostOnce()).findById("13");
    }
}