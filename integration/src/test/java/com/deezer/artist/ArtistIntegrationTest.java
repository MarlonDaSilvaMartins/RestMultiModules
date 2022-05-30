package com.deezer.artist;

import com.deezer.artist.model.response.ArtistIntegrationResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.net.HttpHeaders;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockserver.integration.ClientAndServer;
import org.mockserver.model.HttpRequest;
import org.mockserver.model.HttpResponse;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import static com.deezer.artist.artistintegrationstub.ArtistIntegrationStub.artistIntegrationResponse;
import static com.deezer.artist.artistintegrationstub.ArtistIntegrationStub.artistIntegrationResponseExpect;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockserver.integration.ClientAndServer.startClientAndServer;

@ExtendWith(MockitoExtension.class)
@ContextConfiguration(classes = ArtistIntegration.class)
@EnableWebMvc
@AutoConfigureMockMvc
class ArtistIntegrationTest {

    @InjectMocks
    private ArtistIntegration artistIntegration;

    private static ClientAndServer server;

    @BeforeAll
    static void startServer(){
        server = startClientAndServer();
    }

    @BeforeEach
    void setupClass() {
        RestTemplate restTemplate = new RestTemplateBuilder()
                .rootUri(String.format("http://localhost:%d", server.getPort()))
                .build();

        artistIntegration = new ArtistIntegration(restTemplate);
    }

    @AfterAll
    static void stopServer(){
        server.close();
    }

    @Test
    void whenFindArtistReturnArtistIntegration() throws JsonProcessingException {
        ArtistIntegrationResponse expect = artistIntegrationResponseExpect();

        HttpRequest request =  HttpRequest.request()
                .withPath("/artist/13")
                .withMethod("GET");

        ObjectMapper mapper = new ObjectMapper();

        var body = mapper.writeValueAsString(artistIntegrationResponse());

        HttpResponse response = HttpResponse.response(body)
                .withStatusCode(HttpStatus.OK.value())
                .withHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);

        server.when(request).respond(response);

        var actual = artistIntegration.findArtist("13");
        assertEquals(expect, actual);
    }
}