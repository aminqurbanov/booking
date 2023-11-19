package com.example.relations.controller;

import com.example.relations.domain.RentalCar;
import com.example.relations.dto.Request.RentalCarRequest;
import com.example.relations.dto.Response.RentalCarResponse;
import com.example.relations.service.RentalCarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/rentalcars")
public class RentalCarController {

    private final RentalCarService carService;

    @GetMapping
    public ResponseEntity<List<RentalCarResponse>> findAll(){
        return new ResponseEntity<>(carService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RentalCarResponse> findById(@PathVariable Long id){
        return new ResponseEntity<>(carService.findById(id), HttpStatus.OK);
    }

    @PostMapping("/rental-cars/create")
    public ResponseEntity<RentalCarResponse> save(@RequestBody RentalCarRequest carRequest){
        return new ResponseEntity<>(carService.save(carRequest), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RentalCar> update(@PathVariable Long id, @RequestBody RentalCarRequest carRequest){
        return new ResponseEntity<>(carService.update(id, carRequest), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        carService.delete(id);
    }
}