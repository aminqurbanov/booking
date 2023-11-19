package com.example.relations.controller;

import com.example.relations.dto.Request.FlightRequest;
import com.example.relations.dto.Request.PaymentRequest;
import com.example.relations.dto.Response.FlightResponse;
import com.example.relations.dto.Response.PaymentResponse;
import com.example.relations.service.FlightsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("flights/v1")
public class FlightsController {
    private final FlightsService flightsService;

    @GetMapping
    public ResponseEntity<List<FlightResponse>> findAll(){
        return new ResponseEntity<>(flightsService.findAll(), HttpStatus.OK);
    }
    @PostMapping
    private ResponseEntity<FlightResponse> save(@RequestBody FlightRequest flightsRequest){
        return new ResponseEntity<>(flightsService.save(flightsRequest), HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<FlightResponse> findById(@PathVariable Long id){
        return new ResponseEntity<>(flightsService.findById(id), HttpStatus.OK);

    }
    @PutMapping("/{id}")
    public ResponseEntity<FlightResponse> update(@PathVariable Long id,@RequestBody FlightRequest flightRequest){
        return new ResponseEntity<>(flightsService.update(id, flightRequest), HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        flightsService.delete(id);
    }


}