package com.gridnine.testing.filters;

import com.gridnine.testing.flight.Flight;
import com.gridnine.testing.flight.Segment;

public class ArrivalBeforeDepartureFilter implements FlightFilter {
    @Override
    public boolean isCorrect(Flight flight) {
        for (Segment segment : flight.getSegments()) {
            if (segment.getArrivalDate().isBefore(segment.getDepartureDate())) {
                System.out.println("Flight " + flight + " is removed by 'Arrival before Departure' filter");
                return false;
            }
        }
        return true;
    }
}
