package com.murat.socialmediagraphql.services.implementations;

import com.murat.socialmediagraphql.models.Post;
import com.murat.socialmediagraphql.repositories.PostRepository;
import com.murat.socialmediagraphql.services.PostService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;
    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public List<Post> findPostsByUserId(Long id) {
        return postRepository.findPostByUserId(id);
    }
}
