package com.muratkapparov.carrentapp.CarRentApp.Repository;

import com.muratkapparov.carrentapp.CarRentApp.Entity.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CustomerRepositoryTest {
    @Autowired
    private CustomerRepository customerRepository;
    @Test
    public void save(){
        Customer customer = new Customer();
        customer.setFirstname("Murat");
        customer.setLastname("Xd");
        customer.setEmail("MuratXd@gmail.com");
        customer.setNumber("123-456-789");
        customerRepository.save(customer);
    }
}