package com.deezer;

import com.deezer.artist.ArtistIntegration;
import com.deezer.artist.ArtistService;
import com.deezer.artist.ArtistServiceFacade;
import com.deezer.controller.v1.artist.ArtistController;
import com.deezer.controller.v1.artist.ArtistControllerFacade;
import com.deezer.repository.ArtistRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.AutoConfigureDataMongo;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static com.deezer.appstub.AppStub.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureDataMongo
@WebMvcTest
@ContextConfiguration(classes = {ArtistController.class, ArtistControllerFacade.class, ArtistServiceFacade.class,
        ArtistService.class, ArtistIntegration.class, ArtistRepository.class})
@EnableMongoRepositories("com.deezer.repository")
@TestPropertySource(properties = "spring.mongodb.embedded.version=3.4.5")
class DeezerApplicationTests {
    @Autowired
    MockMvc mockMvc;

    @Autowired
    ArtistRepository artistRepository;

    @MockBean
    ArtistIntegration artistIntegration;

    @Test
    void whenFindArtistByIdAndReturnArtistController() throws Exception {
        var artistControllerResponse = artistControllerResponseExpect();
        var entity = artistEntityStub();

        artistRepository.save(entity);

        ObjectMapper mapper = new ObjectMapper();
        var expect = mapper.writeValueAsString(artistControllerResponse);

        mockMvc.perform(MockMvcRequestBuilders
                        .get("http://localhost:8080/v1/artist/13"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(content().json(expect));
    }

    @Test
    void whenFindArtistIntegraionReturnArtistController() throws Exception {
        var artistId = "13";
        var artistControllerResponse = artistControllerResponseExpect();
        var artistIntegrationResponse = artistIntegrationResponse();

        Mockito.when(artistIntegration.findArtist(artistId))
                .thenReturn(artistIntegrationResponse);

        ObjectMapper mapper = new ObjectMapper();
        var expect = mapper.writeValueAsString(artistControllerResponse);

        mockMvc.perform(MockMvcRequestBuilders
                        .get("http://localhost:8080/v1/artist/13"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(content().json(expect));
    }
}
