package com.example.relations.dto.Request;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@AllArgsConstructor
@FieldDefaults(level= AccessLevel.PRIVATE)
public class RentalCarRequest {

    String rentalCompany;

    String carModel;

    String rentalPeriod;

    Double prices;

    String pickUpLocation;

    String dropOfLocation;
}
