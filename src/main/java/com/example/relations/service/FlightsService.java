package com.example.relations.service;

import com.example.relations.domain.Flights;
import com.example.relations.dto.Request.FlightRequest;
import com.example.relations.dto.Response.FlightResponse;

import java.util.List;

public interface FlightsService {
    List<FlightResponse> findAll();

    FlightResponse save(FlightRequest flightsRequest);
    FlightResponse findById(Long id);
    FlightResponse update(Long id,FlightRequest flightsRequest);
    void delete(Long id);
}
