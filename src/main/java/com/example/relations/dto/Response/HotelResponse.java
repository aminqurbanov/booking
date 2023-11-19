package com.example.relations.dto.Response;

import com.example.relations.domain.Booking;
import com.example.relations.domain.RoomType;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@AllArgsConstructor
@FieldDefaults(level= AccessLevel.PRIVATE)
public class HotelResponse {

    Long id;

    String hotelName;

    String location;

    RoomType roomType;

    Double prices;

    Booking booking;
}
