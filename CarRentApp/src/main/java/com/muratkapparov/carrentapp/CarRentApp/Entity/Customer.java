package com.muratkapparov.carrentapp.CarRentApp.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator= "customer_id_generator"
    )
    @SequenceGenerator(
            name = "customer_id_generator",
            sequenceName = "customer_id_sequence",
            allocationSize = 1
    )
    private Long id;
    @Column(nullable = false)
    private String firstname;
    @Column(nullable = false)
    private String lastname;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String number;
}
