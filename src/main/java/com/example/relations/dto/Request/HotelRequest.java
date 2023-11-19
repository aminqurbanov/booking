package com.example.relations.dto.Request;

import com.example.relations.domain.RoomType;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@AllArgsConstructor
@FieldDefaults(level= AccessLevel.PRIVATE)
public class HotelRequest {

    Long id;

    String hotelName;

    String location;

    RoomType roomType;

    Double prices;
}
