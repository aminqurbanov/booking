package com.example.relations.dto.Response;

import com.example.relations.domain.Booking;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@AllArgsConstructor
@FieldDefaults(level= AccessLevel.PRIVATE)
public class PaymentResponse {
    Long paymentId;

    Double paymentAmount;

    String paymentMethod;

    String paymentDate;

    Booking booking;
}
