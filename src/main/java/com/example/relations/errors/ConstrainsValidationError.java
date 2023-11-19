package com.example.relations.errors;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class ConstrainsValidationError {

    String property;

    String message;
}