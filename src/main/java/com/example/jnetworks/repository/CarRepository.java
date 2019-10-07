package com.example.jnetworks.repository;

import com.example.jnetworks.entity.Car;
import com.querydsl.core.types.Predicate;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long>, QuerydslPredicateExecutor<Car> {


    Car save(Car car);

//    List<Car> findAll();

    long count();

//    List<Car> findAll(Predicate value, PageRequest of);
}
