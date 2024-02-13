package com.murat.socialmediagraphql.controllers;

import com.murat.socialmediagraphql.models.Post;
import com.murat.socialmediagraphql.models.User;
import com.murat.socialmediagraphql.repositories.PostRepository;
import com.murat.socialmediagraphql.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;

import java.util.List;

@Controller
public class MainController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    PostRepository postRepository;
    @QueryMapping
    List<User> users(){
        return userRepository.findAll();
    }
    @QueryMapping
    List<Post> posts(){
        return postRepository.findAll();
    }
}
