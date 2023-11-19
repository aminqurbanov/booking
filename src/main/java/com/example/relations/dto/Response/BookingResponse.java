package com.example.relations.dto.Response;

import com.example.relations.domain.Flights;
import com.example.relations.domain.Hotel;
import com.example.relations.domain.Payment;
import com.example.relations.domain.RentalCar;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@Builder
@FieldDefaults(level= AccessLevel.PRIVATE)
public class BookingResponse {
    Long id;

    String bookingDate;

    Double totalCost;

    List<Flights> flights;

    List<Hotel> hotels;

    List<RentalCar> rentalCars;

    PaymentResponse payment;
}
