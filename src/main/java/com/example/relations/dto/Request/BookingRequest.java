package com.example.relations.dto.Request;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@FieldDefaults(level= AccessLevel.PRIVATE)
public class BookingRequest {

    String bookingDate;

    Double totalCost;
}
