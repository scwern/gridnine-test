package com.gridnine.testing.filters;

import com.gridnine.testing.flight.Flight;
import com.gridnine.testing.flight.Segment;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ArrivalBeforeDepartureFilterTest {

    @Test
    void testFlightWithArrivalBeforeDeparture() {
        Flight flight = new Flight(Arrays.asList(
                new Segment(LocalDateTime.now().plusHours(1), LocalDateTime.now().minusHours(1)))
        );
        ArrivalBeforeDepartureFilter filter = new ArrivalBeforeDepartureFilter();

        assertFalse(filter.isCorrect(flight));
    }
    @Test
    void testFlightWithArrivalAfterDeparture() {
        Flight flight = new Flight(Arrays.asList(
                new Segment(LocalDateTime.now().plusHours(1), LocalDateTime.now().plusHours(2)))
        );
        ArrivalBeforeDepartureFilter filter = new ArrivalBeforeDepartureFilter();

        assertTrue(filter.isCorrect(flight));
    }
}

