package com.muratkapparov.carrentapp.CarRentApp.Controller;

import com.muratkapparov.carrentapp.CarRentApp.Entity.Rent;
import com.muratkapparov.carrentapp.CarRentApp.Service.RentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/rents")
public class RentController {
    @Autowired
    private RentService rentService;
    @GetMapping
    public List<Rent> list(){
        return rentService.returnAll();
    }

}
