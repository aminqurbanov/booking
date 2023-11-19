package com.example.relations.service.serviceImpl;

import com.example.relations.domain.Flights;
import com.example.relations.domain.Payment;
import com.example.relations.dto.Request.FlightRequest;
import com.example.relations.dto.Request.PaymentRequest;
import com.example.relations.dto.Response.FlightResponse;
import com.example.relations.dto.Response.PaymentResponse;
import com.example.relations.repository.FlightRepository;
import com.example.relations.service.FlightsService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
@RequiredArgsConstructor
public class FlightsServiceImpl implements FlightsService {

        private final FlightRepository flightsRepository;
        private final ModelMapper modelMapper;

        @Override
        public List<FlightResponse> findAll() {
            return flightsRepository
                    .findAll()
                    .stream()
                    .map(flights -> modelMapper.map(flights, FlightResponse.class))
                    .collect(Collectors.toList());

        }

        @Override
        public FlightResponse save(FlightRequest flightRequest) {
           Flights flights = modelMapper.map(flightRequest, Flights.class);
            Flights save = flightsRepository.save(flights);
            return modelMapper.map(save, FlightResponse.class);
        }

        @Override
        public FlightResponse findById(Long id) {
            Flights flights = flightsRepository.findById(id).orElseThrow(() -> new RuntimeException(
                    String.format("Flights not found by id-%s", id)
            ));
            return modelMapper.map(flights, FlightResponse.class);
        }

        @Override
        public FlightResponse  update(Long id, FlightRequest flightRequest) {
            flightsRepository.findById(id).orElseThrow(() -> new RuntimeException(
                    String.format("Flights not found for updating by id -%s", id)));
            Flights responseFlight = modelMapper.map(flightRequest, Flights.class);
            responseFlight.setFlightId(id);
            return modelMapper.map(flightsRepository.save(responseFlight), FlightResponse.class);
        }
        @Override
        public void delete(Long id) {
            Flights flights = flightsRepository.findById(id).orElseThrow(() -> new RuntimeException(
                    String.format("Flights not found by Id-%s", id)
            ));
            flightsRepository.delete(flights);
        }

    }
