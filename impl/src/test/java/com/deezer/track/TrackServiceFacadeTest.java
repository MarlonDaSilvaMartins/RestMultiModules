package com.deezer.track;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ContextConfiguration;

import static com.deezer.track.trackservicestub.TrackServiceFacadeStub.trackServiceExpectedStub;
import static com.deezer.track.trackservicestub.TrackServiceFacadeStub.trackServiceStub;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@ContextConfiguration(classes = {TrackServiceFacade.class, TrackService.class})
class TrackServiceFacadeTest {
    @InjectMocks
    TrackServiceFacade trackServiceFacade;

    @Mock
    TrackService trackService;

    @Test
    void whenFindTrackIntegrationReturnTrackServiceResponse() {
        var expected = trackServiceExpectedStub();
        var serviceResponseStub = trackServiceStub();

        when(trackService.findTrack("54428397"))
                .thenReturn(serviceResponseStub);

        var actual = trackServiceFacade.findTrack("54428397");
        assertEquals(expected, actual);
    }
}