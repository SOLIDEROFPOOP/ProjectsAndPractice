package com.muratkapparov.carrentapp.CarRentApp.Repository;

import com.muratkapparov.carrentapp.CarRentApp.Entity.Car;
import com.muratkapparov.carrentapp.CarRentApp.Entity.Customer;
import com.muratkapparov.carrentapp.CarRentApp.Entity.Rent;
import net.bytebuddy.asm.Advice;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class RentRepositoryTest {
    @Autowired
    private RentRepository rentRepository;
    @Test
    public void save(){
        Car car = new Car(2l, "Dodge", "sex", 2022, 50);
        Rent rent = new Rent();
        Customer customer = new Customer(2l ,"John", "xd", "JohbXd@example.com", "123-456-7890");
        rent.setRentStartDate(LocalDate.now());
        rent.setRentEndDate(LocalDate.now().plusDays(10));
        rent.setCar(car);
        rent.setCustomer(customer);
        rentRepository.save(rent);
    }
}