package com.example.project.Controllers;

import com.example.project.data.Category;
import com.example.project.data.Product;
import com.example.project.models.CategoryRepository;
import com.example.project.models.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoriesController {
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ProductRepository productRepository;
    @GetMapping("/{slug}")
    public String category(@PathVariable String slug, Model model ){
        if (slug.equals("all")){
            List<Product> products = productRepository.findAll();
            model.addAttribute("products", products);
        } else {
            Category category = categoryRepository.findBySlug(slug);
            if (category == null) {
                return "redirect:/";
            }
            int categoryId = category.getId();
            String categoryName =category.getName();
            List<Product> products = productRepository.findAllByCategoryId(Integer.toString(categoryId));
            model.addAttribute("products", products);
            model.addAttribute("categoryName", categoryName);
        }
        return "products";
    }
}
