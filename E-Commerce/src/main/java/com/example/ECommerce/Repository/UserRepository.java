package com.example.ECommerce.Repository;

import com.example.ECommerce.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<com.example.ECommerce.Entity.User> findByUsername(String username);
}
