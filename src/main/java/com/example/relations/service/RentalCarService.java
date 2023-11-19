package com.example.relations.service;

import com.example.relations.domain.RentalCar;
import com.example.relations.dto.Request.RentalCarRequest;
import com.example.relations.dto.Response.RentalCarResponse;

import java.util.List;

public interface RentalCarService {

    List<RentalCarResponse> findAll();

    RentalCarResponse findById(Long id);

    RentalCarResponse save(RentalCarRequest carRequest);

    RentalCar update(Long id, RentalCarRequest carRequest);

    void delete(Long id);

}