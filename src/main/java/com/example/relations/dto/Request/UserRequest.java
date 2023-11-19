package com.example.relations.dto.Request;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level= AccessLevel.PRIVATE)
public class UserRequest {

    String name;

    String surname;

    String email;

    String phoneNumber;
}
