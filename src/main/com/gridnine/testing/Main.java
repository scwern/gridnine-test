package com.gridnine.testing;

import com.gridnine.testing.filters.*;
import com.gridnine.testing.flight.*;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Flight> flights = FlightBuilder.createFlights();

        FlightFilter beforeNowFilter = new BeforeNowFilter();
        FlightFilter arrivalBeforeDepartureFilter = new ArrivalBeforeDepartureFilter();
        FlightFilter groundTimeExceeds2HoursFilter = new GroundTimeExceeds2HoursFilter();

        System.out.println("Flights after applying 'Before Now' filter:");
        flights.stream().filter(beforeNowFilter::isCorrect).forEach(System.out::println);

        System.out.println("\nFlights after applying 'Arrival before Departure' filter:");
        flights.stream().filter(arrivalBeforeDepartureFilter::isCorrect).forEach(System.out::println);

        System.out.println("\nFlights after applying 'Ground Time Exceeds 2 Hours' filter:");
        flights.stream().filter(groundTimeExceeds2HoursFilter::isCorrect).forEach(System.out::println);
    }
}
