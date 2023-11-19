package com.example.relations.controller;

import com.example.relations.dto.Request.BookingRequest;
import com.example.relations.dto.Response.BookingResponse;
import com.example.relations.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("booking/v1")
public class BookingController {
    private final BookingService bookingService;
    @GetMapping ("/{id}")
    public ResponseEntity<BookingResponse> findById(@PathVariable Long id){
        return new ResponseEntity<>(bookingService.findById(id), HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<BookingResponse>> findAll() {
        return new ResponseEntity<>(bookingService.findAll(), HttpStatus.OK);
    }
    @PostMapping("/payments/{paymentId}/users/{userId}")
    public ResponseEntity<BookingResponse> save(@PathVariable Long userId,
                                                @PathVariable Long paymentId,
                                                @RequestBody BookingRequest bookingRequest){
        return new ResponseEntity<>(bookingService.save(userId,paymentId,bookingRequest), HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        bookingService.delete(id);
    }
}
