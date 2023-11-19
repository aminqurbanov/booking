package com.example.relations.dto.Response;

import com.example.relations.domain.Booking;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.awt.print.Book;

@Data
@Builder
@AllArgsConstructor
@FieldDefaults(level= AccessLevel.PRIVATE)
public class RentalCarResponse {

    Long id;

    String rentalCompany;

    String carModel;

    String rentalPeriod;

    Double prices;

    String pickUpLocation;

    String dropOfLocation;

    Booking booking;
}
