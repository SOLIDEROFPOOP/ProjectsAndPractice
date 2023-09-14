package com.muratkapparov.carrentapp.CarRentApp.Repository;

import com.muratkapparov.carrentapp.CarRentApp.Entity.Rent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentRepository extends JpaRepository<Rent, Long> {

}
