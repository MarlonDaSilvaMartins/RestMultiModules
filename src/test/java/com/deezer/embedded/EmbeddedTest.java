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
import org.springframework.context.ApplicationContext;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Optional;

import static com.deezer.embedded.embeddedstub.EmbeddedStub.artistEntityStub;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@DataMongoTest(excludeAutoConfiguration = EmbeddedMongoAutoConfiguration.class)
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {ArtistService.class, ArtistRepository.class})
@EnableMongoRepositories("com.deezer.repository")
@TestPropertySource(properties = "spring.mongodb.embedded.version=3.4.5")
class EmbeddedTest {
//    @Autowired
//    WebApplicationContext webApplicationContext;
//
//    MockMvc mvc;

    @Autowired
    ArtistService artistService;

    @Autowired
    ArtistRepository artistRepository;

    @MockBean
    ArtistIntegration artistIntegration;

    @BeforeEach
    void setUp(){
//        this.mvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();

        var entity = artistEntityStub();
        artistRepository.save(entity);
    }

    @Test
    void whenDeleteTrackReturnNothing() throws Exception {
        String artistId = "13";

        artistService.deleteArtist(artistId);

//        mvc.perform(MockMvcRequestBuilders
//                        .delete("http://localhost:8080/v1/artist/13"))
//                .andExpect(status().isNoContent());

        assertEquals(Optional.empty(),artistService.findArtistById(artistId));
    }
}
