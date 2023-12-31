package com.example.project.data;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "products")
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Size(min=2, message= "Name must be at least 2 characters long")
    private String name;

    private String slug;
    @Size(min=5, message= "Description must be at least 5 characters long")
    private String description;

    private String image;
    @Pattern(regexp = "^[0-9]+(\\.[0-9]{1,2})?", message = "Price must be a number 5, 5.99,15, 15.99")
    private String price;
    @Column(name = "category_id")
    @Pattern(regexp = "^[1-9][0-9]*", message = "Please choose a category")
    private String categoryId;
    @Column(name = "created_at" , updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;
    @Column(name = "updated_at")
    @UpdateTimestamp
    private LocalDateTime updatedAt;
}
