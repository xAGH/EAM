package com.parciales.parcial1.dao;

import org.springframework.data.repository.CrudRepository;

import com.parciales.parcial1.domain.Car;

public interface CarDao extends CrudRepository<Car, Integer> {
    
}
