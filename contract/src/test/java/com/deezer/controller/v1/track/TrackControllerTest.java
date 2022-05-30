package com.deezer.controller.v1.track;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static com.deezer.controller.v1.track.trackcontrollerstub.TrackControllerStub.trackControllerExpectedStub;
import static com.deezer.controller.v1.track.trackcontrollerstub.TrackControllerStub.trackControllerStub;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(TrackController.class)
@ContextConfiguration(classes = {TrackController.class, TrackControllerFacade.class})
class TrackControllerTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private TrackControllerFacade trackControllerFacade;

    @Test
    void  whenFindTrackReturnTrackController() throws Exception {
        String trackId = "54428397";
        var controllerExpect = trackControllerExpectedStub();
        var controllerResponse = trackControllerStub();

        when(trackControllerFacade.findTrack(trackId))
                .thenReturn(controllerResponse);

        ObjectMapper mapper = new ObjectMapper();

        var expect = mapper.writeValueAsString(controllerExpect);

        mvc.perform(MockMvcRequestBuilders
                        .get("http://localhost:8080/v1/track/54428397"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(content().json(expect));
    }
}