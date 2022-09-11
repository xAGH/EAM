package com.parciales.parcial1.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.parciales.parcial1.dao.CarDao;
import com.parciales.parcial1.domain.Car;
import com.parciales.parcial1.services.CarService;

@Service
public class CarImplementation implements CarService{

    @Autowired
    private CarDao carDao;

    @Transactional(readOnly = true)
    @Override
    public List<Car> getAll() {
        return (List<Car>) carDao.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Car getOne(Car car) {
        return carDao.findById(car.getId()).orElse(null);
    }

    @Transactional
    @Override
    public void save(Car car) {
        carDao.save(car);
    }

    @Transactional
    @Override
    public void delete(Car car) {
        carDao.delete(car);
    }
}
