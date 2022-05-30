//package com.deezer.track;
//
//import com.deezer.track.model.response.TrackIntegrationResponse;
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.google.common.net.HttpHeaders;
//import org.junit.jupiter.api.AfterAll;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.mockserver.integration.ClientAndServer;
//import org.mockserver.model.HttpRequest;
//import org.mockserver.model.HttpResponse;
//import org.springframework.boot.web.client.RestTemplateBuilder;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.web.client.RestTemplate;
//
//import static com.deezer.track.trackintegrationstub.TrackIntegrationStub.trackIntegrationExpectStub;
//import static com.deezer.track.trackintegrationstub.TrackIntegrationStub.trackIntegrationStub;
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockserver.integration.ClientAndServer.startClientAndServer;
//
//@ExtendWith(MockitoExtension.class)
//@ContextConfiguration(classes = TrackIntegration.class)
//class TrackIntegrationTest {
//    @InjectMocks
//    private TrackIntegration trackIntegration;
//
//    private static ClientAndServer server;
//
//    @BeforeAll
//    static void startServer(){
//        server = startClientAndServer();
//    }
//
//    @BeforeEach
//    void setupClass() {
//        RestTemplate restTemplate = new RestTemplateBuilder()
//                .rootUri(String.format("http://localhost:%d", server.getPort()))
//                .build();
//
//        trackIntegration = new TrackIntegration(restTemplate);
//    }
//
//    @AfterAll
//    static void stopServer(){
//        server.close();
//    }
//
//    @Test
//    void whenFindTrackReturnArtistIntegration() throws JsonProcessingException {
//        TrackIntegrationResponse expected = trackIntegrationExpectStub();
//
//        HttpRequest request =  HttpRequest.request()
//                .withPath("/tracks/details")
//                .withQueryStringParameter("track_id", "54428397")
//                .withMethod("GET");
//
//        ObjectMapper mapper = new ObjectMapper();
//
//        var body = mapper.writeValueAsString(trackIntegrationStub());
//
//        HttpResponse response = HttpResponse.response(body)
//                .withStatusCode(HttpStatus.OK.value())
//                .withHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
//
//        server.when(request).respond(response);
//
//        var actual = trackIntegration.findTrack("13");
//        assertEquals(expected, actual);
//    }
//}