package com.gridnine.testing.filters;

import com.gridnine.testing.flight.Flight;
import com.gridnine.testing.flight.Segment;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GroundTimeExceeds2HoursFilterTest {

    @Test
    void testFlightWithGroundTimeExceeding2Hours() {
        Flight flight = new Flight(Arrays.asList(
                new Segment(LocalDateTime.now().plusHours(1), LocalDateTime.now().plusHours(3)),
                new Segment(LocalDateTime.now().plusHours(6), LocalDateTime.now().plusHours(8)))
        );
        GroundTimeExceeds2HoursFilter filter = new GroundTimeExceeds2HoursFilter();

        assertFalse(filter.isCorrect(flight));
    }

    @Test
    void testFlightWithGroundTimeLessThan2Hours() {
        Flight flight = new Flight(Arrays.asList(
                new Segment(LocalDateTime.now().plusHours(1), LocalDateTime.now().plusHours(3)),
                new Segment(LocalDateTime.now().plusHours(4), LocalDateTime.now().plusHours(5)))
        );
        GroundTimeExceeds2HoursFilter filter = new GroundTimeExceeds2HoursFilter();

        assertTrue(filter.isCorrect(flight));
    }

}
