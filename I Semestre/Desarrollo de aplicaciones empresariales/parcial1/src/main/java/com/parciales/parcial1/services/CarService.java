package com.parciales.parcial1.services;

import java.util.List;

import com.parciales.parcial1.domain.Car;

public interface CarService {
    
    public List<Car> getAll();
    public Car getOne(Car car);
    public void save(Car car);
    public void delete(Car car);

}
