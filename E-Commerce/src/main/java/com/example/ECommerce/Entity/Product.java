package com.example.ECommerce.Entity;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.Data;

@Entity
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "id_product_generator")
    @SequenceGenerator(name = "id_product_generator" , sequenceName = "id_product_sequence" , allocationSize = 1)
    private Long id;
    private String name;
    private String type;
    private String Description;
    @OneToOne(mappedBy = "product")
    private Stock stock;
}
