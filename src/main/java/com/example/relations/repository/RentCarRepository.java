package com.example.relations.repository;

import com.example.relations.domain.RentalCar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentCarRepository extends JpaRepository<RentalCar,Long> {
}
