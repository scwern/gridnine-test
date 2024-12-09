package com.gridnine.testing.filters;

import com.gridnine.testing.flight.Flight;
import com.gridnine.testing.flight.Segment;

import java.time.Duration;
import java.util.List;

public class GroundTimeExceeds2HoursFilter implements FlightFilter {
    @Override
    public boolean isCorrect(Flight flight) {
        List<Segment> segments = flight.getSegments();
        for (int i = 0; i < segments.size() - 1; i++) {
            Segment currentSegment = segments.get(i);
            Segment nextSegment = segments.get(i + 1);
            Duration groundTime = Duration.between(currentSegment.getArrivalDate(), nextSegment.getDepartureDate());
            if (groundTime.toHours() > 2) {
                System.out.println("Flight " + flight + " is removed by 'Ground Time Exceeds 2 Hours' filter");
                return false;
            }
        }
        return true;
    }
}
