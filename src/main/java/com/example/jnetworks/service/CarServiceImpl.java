package com.example.jnetworks.service;

import com.example.jnetworks.entity.Car;
import com.example.jnetworks.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    CarRepository carRepository;

    @Override
    public List<Car> findAll() {
        return carRepository.findAll();
    }

    @Override
    public long getCount() {
        return carRepository.count();
    }

    @Override
    public Car saveCar(Car car) {
        car.setTimestamp(new Timestamp(System.currentTimeMillis()));
        return carRepository.save(car);
    }
}
