package com.deezer.embedded;

import com.deezer.artist.ArtistIntegration;
import com.deezer.artist.ArtistService;
import com.deezer.repository.ArtistRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mongo.embedded.EmbeddedMongoAutoConfiguration;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static com.deezer.embedded.embeddedstub.EmbeddedStub.artistEntityStub;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DataMongoTest(excludeAutoConfiguration = EmbeddedMongoAutoConfiguration.class)
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {ArtistService.class, ArtistRepository.class})
@EnableMongoRepositories("com.deezer.repository")
@TestPropertySource(properties = "spring.mongodb.embedded.version=3.4.5")
class EmbeddedTest {
    @Autowired
    ArtistService artistService;

    @Autowired
    ArtistRepository artistRepository;

    @MockBean
    ArtistIntegration artistIntegration;

    @BeforeEach
    void setUp(){
        var entity = artistEntityStub();

        artistRepository.save(entity);
    }

    @Test
    void whenDeleteTrackReturnNothing(){
        String artistId = "13";

        artistService.deleteArtist(artistId);

        assertEquals(Optional.empty(),artistService.findArtistById(artistId));
    }
}
