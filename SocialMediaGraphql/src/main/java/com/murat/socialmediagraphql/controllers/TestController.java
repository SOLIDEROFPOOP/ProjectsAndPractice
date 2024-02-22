package com.murat.socialmediagraphql.controllers;

import com.murat.socialmediagraphql.models.Post;
import com.murat.socialmediagraphql.models.User;
import com.murat.socialmediagraphql.repositories.PostRepository;
import com.murat.socialmediagraphql.repositories.UserRepository;
import com.murat.socialmediagraphql.services.PostService;
import com.murat.socialmediagraphql.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class TestController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    PostRepository postRepository;
    @Autowired
    UserService userService;
    @Autowired
    PostService postService;
    @QueryMapping
    List<User> users(){
        return userRepository.findAll();
    }
    @QueryMapping
    List<Post> posts(){
        return postRepository.findAll();
    }
    @QueryMapping
    User user(@Argument String username){
        return userService.getUserByUsername(username);
    }
    @QueryMapping
    List<Post> findPostsByUserId(@Argument Long id){
        return postService.findPostsByUserId(id);
    }
    @MutationMapping
    Post createPost(@Argument CreatePostInput CreatePostInput){
        Post post = new Post();
        post.setContent(CreatePostInput.content);
        Optional<User> user = userRepository.findById(CreatePostInput.userId);
        post.setUser(user.get());
        return postService.addPost(post);
    }
    public record CreatePostInput(String content, Long userId){}
}
