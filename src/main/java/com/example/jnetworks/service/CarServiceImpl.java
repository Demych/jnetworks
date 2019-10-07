package com.example.jnetworks.service;

import com.example.jnetworks.entity.Car;
import com.example.jnetworks.entity.QCar;
import com.example.jnetworks.repository.CarRepository;
import com.querydsl.core.BooleanBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    CarRepository carRepository;

    @Override
    public Page<Car> findAll(int page, int size, String carNumber, String timestamp) throws ParseException {
        BooleanBuilder predicate = new BooleanBuilder();
        QCar car = QCar.car;
        if (carNumber != null && !carNumber.isEmpty()) {
            predicate.and(car.carNumber.eq(carNumber));
        }
        if (timestamp != null) {
            Timestamp startTime = getStartTime(timestamp);
            Timestamp endTime = getEndTime(startTime);
            predicate.and(car.timestamp.between(startTime, endTime));
        }
        return carRepository.findAll(predicate, PageRequest.of(page, size));
    }

    private Timestamp getStartTime(String timestamp) throws ParseException {
        DateFormat df = new SimpleDateFormat("yyyyMMdd");
        return new Timestamp(df.parse(timestamp).getTime());
    }

    private Timestamp getEndTime(Timestamp startTime) {
        Timestamp endTime = new Timestamp(startTime.getTime());
        endTime.setHours(23);
        endTime.setMinutes(59);
        endTime.setSeconds(59);
        endTime.setNanos(999999999);
        return endTime;
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
