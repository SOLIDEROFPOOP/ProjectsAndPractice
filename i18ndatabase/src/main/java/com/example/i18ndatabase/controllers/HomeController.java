package com.example.i18ndatabase.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;
import java.util.Objects;

@Controller
public class HomeController {
    @RequestMapping("/")
    public String welcome(Map<String, Object> model){
        return "index";
    }
}
