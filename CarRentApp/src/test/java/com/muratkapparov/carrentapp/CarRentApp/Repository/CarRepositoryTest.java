package com.muratkapparov.carrentapp.CarRentApp.Repository;

import com.muratkapparov.carrentapp.CarRentApp.Entity.Car;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CarRepositoryTest {
    @Autowired
    private CarRepository carRepository;
    @Test
    public void save(){
        Car car = new Car();
        car.setBrand("Dodge");
        car.setModel("Hellcat");
        car.setYear(2022);
        car.setRentalPricePerDay(150);
        carRepository.save(car);
    }
}