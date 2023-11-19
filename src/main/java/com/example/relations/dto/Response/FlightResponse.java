package com.example.relations.dto.Response;

import com.example.relations.domain.Booking;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@AllArgsConstructor
@FieldDefaults(level= AccessLevel.PRIVATE)
public class FlightResponse {

    Long id;

    String flightNumber;

    String departureAirport;

    String arrivalAirport;

    String departureTime;

    String arrivalTime;

    String airline;

    Booking booking;
}
