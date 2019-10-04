package com.example.jnetworks.repository;

import com.example.jnetworks.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CarRepository extends CrudRepository<Car, Long> {


    Car save(Car car);

    List<Car> findAll();

    long count();
}
