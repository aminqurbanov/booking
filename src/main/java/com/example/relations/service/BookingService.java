package com.example.relations.service;

import com.example.relations.dto.Request.BookingRequest;
import com.example.relations.dto.Response.BookingResponse;

import java.util.List;

public interface BookingService {
    BookingResponse findById(Long id);
    List<BookingResponse> findAll();
    BookingResponse save(Long userId, Long paymentId, BookingRequest bookingRequest);

    void delete(Long id);
}