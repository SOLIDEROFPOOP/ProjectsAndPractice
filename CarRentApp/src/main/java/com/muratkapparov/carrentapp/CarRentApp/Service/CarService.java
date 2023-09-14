package com.muratkapparov.carrentapp.CarRentApp.Service;

import com.muratkapparov.carrentapp.CarRentApp.Entity.Car;
import com.muratkapparov.carrentapp.CarRentApp.Repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {
    private CarRepository carRepository;
    @Autowired
    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }
    public List<Car> returnAll(){
        List<Car> cars = carRepository.findAll();
        return cars;
    }
}
