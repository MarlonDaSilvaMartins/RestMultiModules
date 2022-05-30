package com.deezer.controller.v1.artist;

import com.deezer.controller.v1.artist.artistcontrollerstub.ArtistControllerStub;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ArtistController.class)
@ContextConfiguration(classes = {ArtistController.class, ArtistControllerFacade.class})
class ArtistControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private ArtistControllerFacade artistControllerFacade;

    @Test
    void whenFindArtistAndReturnArtistController() throws Exception {
        var artistControllerResponse = ArtistControllerStub.artistControllerResponse();
        var artistControllerExpect = ArtistControllerStub.artistControllerResponseExpect();

        Mockito.when(artistControllerFacade.findArtist("13"))
                .thenReturn(artistControllerResponse);

        ObjectMapper mapper = new ObjectMapper();

        var expect = mapper.writeValueAsString(artistControllerExpect);

        mvc.perform(MockMvcRequestBuilders
                        .get("http://localhost:8080/v1/artist/13"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(content().json(expect));
    }

    @Test
    void whenDeleteArtistReturnNothing() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                        .delete("http://localhost:8080/v1/artist/13"))
                .andExpect(status().isNoContent());
    }
}