package com.gridnine.testing.filters;

import com.gridnine.testing.flight.Flight;
import com.gridnine.testing.flight.Segment;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BeforeNowFilterTest {

    @Test
    void testFlightWithDepartureBeforeNow() {
        Flight flight = new Flight(Arrays.asList(
                new Segment(LocalDateTime.now().minusDays(1), LocalDateTime.now().plusHours(2)))
        );

        BeforeNowFilter filter = new BeforeNowFilter();
        assertFalse(filter.isCorrect(flight));
    }
    @Test
    void testFlightWithDepartureAfterNow() {
        Flight flight = new Flight(Arrays.asList(
                new Segment(LocalDateTime.now().plusHours(1), LocalDateTime.now().plusHours(3)))
        );
        BeforeNowFilter filter = new BeforeNowFilter();

        assertTrue(filter.isCorrect(flight));
    }
}
