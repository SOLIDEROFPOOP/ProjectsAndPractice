package com.example.project.data;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.annotations.BatchSize;

@Entity
@Table(name = "pages")
@Data
public class Page {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Size(min=2, message= "Title must be at least 2 characters long")
    private String title;
    private String slug;
    @Size(min=5, message= "Title must be at least 5 characters long")
    private String content;
    private int sorting;
}
