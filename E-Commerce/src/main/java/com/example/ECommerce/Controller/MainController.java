package com.example.ECommerce.Controller;



import com.example.ECommerce.Entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("/login")
    public String login(Model model){
        model.addAttribute("user" , new User());
        return "logi";
    }
}
