package com.deezer.artist.embedded;

import com.deezer.artist.ArtistIntegration;
import com.deezer.artist.ArtistService;
import com.deezer.artist.ArtistServiceFacade;
import com.deezer.controller.v1.artist.ArtistController;
import com.deezer.controller.v1.artist.ArtistControllerFacade;
import com.deezer.repository.ArtistRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.AutoConfigureDataMongo;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Optional;

import static com.deezer.artist.embedded.embeddedstub.EmbeddedStub.artistEntityStub;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureDataMongo
@WebMvcTest
@ContextConfiguration(classes = {ArtistController.class, ArtistControllerFacade.class, ArtistServiceFacade.class,
        ArtistService.class, ArtistIntegration.class, ArtistRepository.class})
@EnableMongoRepositories("com.deezer.repository")
@TestPropertySource(properties = "spring.mongodb.embedded.version=3.4.5")
class ArtistServiceTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ArtistRepository artistRepository;

    @MockBean
    ArtistIntegration artistIntegration;

    @Test
    void whenDeleteTrackReturnNothing() throws Exception {
        String artistId = "13";
        var entity = artistEntityStub();

        artistRepository.save(entity);

        mockMvc.perform(MockMvcRequestBuilders
                        .delete("http://localhost:8080/v1/artist/".concat(artistId)))
                .andExpect(status().isNoContent());

        var actual = artistRepository.findById(artistId);
        assertEquals(Optional.empty(),actual);
    }
}