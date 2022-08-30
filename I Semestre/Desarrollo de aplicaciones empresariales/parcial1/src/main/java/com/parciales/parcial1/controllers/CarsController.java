package com.parciales.parcial1.controllers;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.parciales.parcial1.domain.Car;
import com.parciales.parcial1.services.CarService;

@Controller
public class CarsController {

    @Autowired
    private CarService carService;
   
    @GetMapping("/")
    public String showCars(Model model){
        ArrayList<Car> cars = (ArrayList<Car>) carService.getAll();
        model.addAttribute("cars", cars);
        model.addAttribute("noCars", cars ==  null || cars.isEmpty());
        return "index";
    }

    @GetMapping("/create")
    public String create(Car car, Model model){
        return "create-update";
    }

    @GetMapping("/create/{id}")
    public String editCar(Car car, Model model){
        model.addAttribute("car", carService.getOne(car));
        return "create-update";
    }

    @PostMapping("/save")
    public String register(@Valid Car car, Errors errors){
        if (errors.hasErrors()){
            return "create-update";
        }
        carService.save(car);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String delete(Car car){
        carService.delete(car);
        return "redirect:/";
    }
}
