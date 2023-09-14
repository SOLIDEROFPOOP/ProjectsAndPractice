package com.muratkapparov.carrentapp.CarRentApp.Controller;

import com.muratkapparov.carrentapp.CarRentApp.Entity.Customer;
import com.muratkapparov.carrentapp.CarRentApp.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @GetMapping()
    public List<Customer> list(){
        return customerService.returnAll();
    }
}
