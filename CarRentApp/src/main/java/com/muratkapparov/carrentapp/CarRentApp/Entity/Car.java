package com.muratkapparov.carrentapp.CarRentApp.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name="cars")
public class Car {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator= "cars_id_generator"
    )
    @SequenceGenerator(
            name = "cars_id_generator",
            sequenceName = "cars_id_sequence",
            allocationSize = 1
    )
    private Long id;
    @Column(nullable = false)
    private String brand;
    @Column(nullable = false)
    private String model;
    @Column(nullable = false)
    private Integer year;
    @Column(nullable = false)
    private Integer rentalPricePerDay;
}
