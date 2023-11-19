package com.example.relations.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@FieldDefaults(level= AccessLevel.PRIVATE)
@Table(name = "hotels")
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    Long hotelId;

    String hotelName;

    String location;

    @Enumerated(EnumType.STRING)
    RoomType roomType;
    Double prices;

    @ManyToOne
    @JsonIgnore
    @ToString.Exclude
    Booking booking;
}
