package com.example.jnetworks.service;

import com.example.jnetworks.dto.CarDto;
import com.example.jnetworks.entity.Car;
import com.example.jnetworks.entity.CarsCount;
import com.example.jnetworks.entity.QCar;
import com.example.jnetworks.repository.CarRepository;
import com.querydsl.core.BooleanBuilder;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    CarRepository carRepository;

    @Autowired
    Mapper mapper;

    @Override
    public List<CarDto> findAll(int page, int size, String carNumber, String timestamp) throws ParseException {
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
        List<Car> cars = carRepository.findAll(predicate, PageRequest.of(page, size)).getContent();
        return cars.stream().map(car1 -> mapper.map(car1, CarDto.class)).collect(Collectors.toList());
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
    public CarsCount getCount() {
        return new CarsCount(carRepository.count());
    }

    @Override
    public CarDto saveCar(Car car) {
        car.setTimestamp(new Timestamp(System.currentTimeMillis()));
        return mapper.map(carRepository.save(car), CarDto.class);
    }
}
