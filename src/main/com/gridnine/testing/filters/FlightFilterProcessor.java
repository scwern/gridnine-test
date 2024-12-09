package com.gridnine.testing.filters;

import com.gridnine.testing.flight.Flight;

import java.util.List;
import java.util.stream.Collectors;

public class FlightFilterProcessor {

    private final List<FlightFilter> filters;

    public FlightFilterProcessor(List<FlightFilter> filters) {
        this.filters = filters;
    }

    public List<Flight> filterFlights (List<Flight> flights){

        return flights.stream()
                .filter(flight -> filters.stream().allMatch(filter -> filter.isCorrect(flight)))
                .collect(Collectors.toList());

    }

    public static void printFilteredFlights(List<Flight> flights) {
        if(flights.isEmpty()){
            System.out.println("No flights found");
        }else {
            flights.forEach(System.out::println);
        }
    }

}
