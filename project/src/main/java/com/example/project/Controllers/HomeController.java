package com.example.project.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {
    @GetMapping("/SomeRandomPage")
    public String home() {
        return "page";
    }

}
