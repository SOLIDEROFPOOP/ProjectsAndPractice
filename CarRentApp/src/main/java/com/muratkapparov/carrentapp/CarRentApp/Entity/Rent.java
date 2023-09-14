package com.muratkapparov.carrentapp.CarRentApp.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "rents")
public class Rent {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator= "rent_id_generator"
    )
    @SequenceGenerator(
            name = "rent_id_generator",
            sequenceName = "rent_id_sequence",
            allocationSize = 1
    )
    private Long id;
    @Column(nullable = false)
    private LocalDate rentStartDate;
    @Column(nullable = false)
    private LocalDate rentEndDate;
    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
}
