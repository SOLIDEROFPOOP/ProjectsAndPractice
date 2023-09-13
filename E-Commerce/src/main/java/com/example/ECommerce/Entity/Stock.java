package com.example.ECommerce.Entity;

import jakarta.persistence.*;

@Entity
public class Stock {
    @Id
    private Long id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;
    private Integer number;
}
