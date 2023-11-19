package com.example.relations.dto.Response;


import lombok.*;
import lombok.experimental.FieldDefaults;


import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level= AccessLevel.PRIVATE)
public class UserResponse {

    Long userId;

    String name;

    String surname;

    String email;

    String phoneNumber;

    List<BookingResponse> bookings;
}
