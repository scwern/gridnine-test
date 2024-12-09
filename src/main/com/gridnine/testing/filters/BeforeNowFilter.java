package com.gridnine.testing.filters;

import com.gridnine.testing.flight.Flight;
import com.gridnine.testing.flight.Segment;

import java.time.LocalDateTime;

public class BeforeNowFilter implements FlightFilter {
    @Override
    public boolean isCorrect(Flight flight) {
        for (Segment segment : flight.getSegments()) {
            if (segment.getDepartureDate().isBefore(LocalDateTime.now())) {
                System.out.println("Flight " + flight + " is removed by 'Before Now' filter");
                return false;
            }
        }
        return true;
    }
}
