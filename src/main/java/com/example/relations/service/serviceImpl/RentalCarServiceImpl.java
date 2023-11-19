package com.example.relations.service.serviceImpl;

import com.example.relations.domain.RentalCar;
import com.example.relations.dto.Request.RentalCarRequest;
import com.example.relations.dto.Response.RentalCarResponse;
import com.example.relations.errors.ApplicationException;
import com.example.relations.errors.Errors;
import com.example.relations.repository.RentCarRepository;
import com.example.relations.service.RentalCarService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RentalCarServiceImpl implements RentalCarService {

    private final RentCarRepository rentCarRepository;

    private final ModelMapper modelMapper;

    @Override
    public List<RentalCarResponse> findAll() {
        return rentCarRepository
                .findAll()
                .stream()
                .map(RentalCar -> modelMapper.map(RentalCar, RentalCarResponse.class))
                .collect(Collectors.toList());
    }

    @Override
    public RentalCarResponse findById(Long id) {
        RentalCar car = rentCarRepository.findById(id).orElseThrow(() ->
                new ApplicationException(Errors.CAR_NOT_FOUND));
        return modelMapper.map(car, RentalCarResponse.class);
    }


    @Override
    public RentalCarResponse save(RentalCarRequest carRequest) {
        RentalCar car = modelMapper.map(carRequest, RentalCar.class);
        return modelMapper.map(rentCarRepository.save(car), RentalCarResponse.class);
    }

    @Override
    public RentalCar update(Long id, RentalCarRequest carRequest) {
        rentCarRepository.findById(id).orElseThrow(() -> new ApplicationException(Errors.CAR_NOT_FOUND));
        RentalCar responseCar = modelMapper.map(carRequest, RentalCar.class);
        responseCar.setId(id);
        return modelMapper.map(rentCarRepository.save(responseCar), RentalCar.class);
    }

    @Override
    public void delete(Long id) {
        RentalCar car = rentCarRepository.findById(id).orElseThrow(() ->
                new ApplicationException(Errors.CAR_NOT_FOUND));
        rentCarRepository.delete(car);
    }
}