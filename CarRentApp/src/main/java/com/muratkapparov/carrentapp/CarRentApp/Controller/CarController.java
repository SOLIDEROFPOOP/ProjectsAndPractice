package com.muratkapparov.carrentapp.CarRentApp.Controller;

import com.muratkapparov.carrentapp.CarRentApp.Entity.Car;
import com.muratkapparov.carrentapp.CarRentApp.Service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/cars")
public class CarController {
    @Autowired
    private CarService carService;
    @GetMapping()
    public List<Car> list(){
        return carService.returnAll();
    }
}
