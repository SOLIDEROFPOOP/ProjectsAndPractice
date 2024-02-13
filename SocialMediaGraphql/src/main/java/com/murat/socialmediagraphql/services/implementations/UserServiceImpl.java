package com.murat.socialmediagraphql.services.implementations;

import com.murat.socialmediagraphql.models.User;
import com.murat.socialmediagraphql.repositories.UserRepository;
import com.murat.socialmediagraphql.services.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    @Override
    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
