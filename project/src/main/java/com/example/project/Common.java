package com.example.project;

import com.example.project.data.Category;
import com.example.project.data.Page;
import com.example.project.models.Cart;
import com.example.project.models.CategoryRepository;
import com.example.project.models.PageRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.HashMap;
import java.util.List;

@ControllerAdvice
public class Common {
    @Autowired
    private PageRepository pageRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @ModelAttribute
    public void  sharedData(Model model, HttpSession session){
        List<Page> pages = pageRepository.findAllByOrderBySortingAsc();
        List<Category> categories = categoryRepository.findAll();
        boolean cartActive = false;
        if (session.getAttribute("cart") != null){
            HashMap<Integer , Cart> cart = (HashMap<Integer, Cart>) session.getAttribute("cart");
            int size = 0;
            double total = 0;
            for (Cart value : cart.values()){
                size += value.getQuantity();
                total += value.getQuantity() * Double.parseDouble(value.getPrice());
            }
            model.addAttribute("csize" , size);
            model.addAttribute("ctotal" , total);
            cartActive = true;
        }
        model.addAttribute("cpages" , pages);
        model.addAttribute("categories" , categories);
        model.addAttribute("cartActive" , cartActive);
    }
}
