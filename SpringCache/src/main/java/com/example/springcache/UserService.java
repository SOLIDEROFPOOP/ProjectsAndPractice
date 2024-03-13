package com.example.springcache;

import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class UserService {
    private final UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public User create(User user) {
        return userRepository.save(user);
    }
    @Cacheable("users")
    public User get(Long id){
        log.info("Getting user with id {}.", id);
        return userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("User with id " + id + " not found."));
    }
    @Cacheable(value = "users", key = "#name")
    public User create(String name, String email) {
        log.info("creating user with parameters: {}, {}", name, email);
        return userRepository.save(new User(name, email));
    }
    public List<User> getAll() {
        return userRepository.findAll();
    }
}
