package com.deezer.track;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ContextConfiguration;

import static com.deezer.track.trackservicestub.TrackServiceStub.trackIntegrationStub;
import static com.deezer.track.trackservicestub.TrackServiceStub.trackServiceExpectedStub;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@ContextConfiguration(classes = {TrackService.class, TrackIntegration.class})
class TrackServiceTest {

    @InjectMocks
    TrackService trackService;

    @Mock
    TrackIntegration trackIntegration;

    @Test
    void whenFindTrackIntegrationReturnTrackserviceResponse() {
        var expected = trackServiceExpectedStub();
        var integrationResponse = trackIntegrationStub();

        when(trackIntegration.findTrack("54428397"))
                .thenReturn(integrationResponse);

        var actual = trackService.findTrack("54428397");
        assertEquals(expected, actual);
    }
}