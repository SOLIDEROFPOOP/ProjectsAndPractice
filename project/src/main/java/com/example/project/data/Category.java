package com.example.project.data;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Table(name = "categories")
@Data
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Size(min=2, message= "Title must be at least 2 characters long")
    private String name;
    private String slug;
    private int sorting;

}

