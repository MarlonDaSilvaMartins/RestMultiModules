package com.deezer.controller.v1.track;

import com.deezer.controller.v1.track.model.response.TrackControllerResponse;
import com.deezer.track.TrackServiceFacade;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ContextConfiguration;

import static com.deezer.controller.v1.track.trackcontrollerstub.TrackControllerFacadeStub.trackControllerExpectedStub;
import static com.deezer.controller.v1.track.trackcontrollerstub.TrackControllerFacadeStub.trackServiceStub;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@ContextConfiguration(classes = {TrackControllerFacade.class, TrackServiceFacade.class})
class TrackControllerFacadeTest {
    @InjectMocks
    TrackControllerFacade trackControllerFacade;

    @Mock
    TrackServiceFacade trackServiceFacade;

    @Test
    void whenFindTrackReturnTrackControllerResponse() {
        var expected = trackControllerExpectedStub();
        var serviceResponseStub = trackServiceStub();

        when(trackServiceFacade.findTrack("54428397"))
                .thenReturn(serviceResponseStub);

        var actual = trackControllerFacade.findTrack("54428397");
        assertEquals(expected, actual);
    }
}