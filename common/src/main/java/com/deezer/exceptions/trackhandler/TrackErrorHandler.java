package com.deezer.exceptions.trackhandler;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.DefaultResponseErrorHandler;

import java.io.IOException;

public class TrackErrorHandler extends DefaultResponseErrorHandler {
    @Override
    public void handleError(ClientHttpResponse httpResponse) throws IOException {
        if (httpResponse.getStatusCode() == HttpStatus.UNPROCESSABLE_ENTITY) {
            ObjectMapper objectMapper = new ObjectMapper();

            TrackErrorResponse trackErrorResponse = objectMapper.readValue(httpResponse.getBody().readAllBytes(),TrackErrorResponse.class);

            throw new TrackErrorException(trackErrorResponse);
        }
    }
}
