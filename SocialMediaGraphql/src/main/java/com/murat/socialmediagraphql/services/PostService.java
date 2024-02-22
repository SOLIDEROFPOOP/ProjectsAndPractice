package com.murat.socialmediagraphql.services;

import com.murat.socialmediagraphql.models.Post;

import java.util.List;

public interface PostService {
    List<Post> findPostsByUserId(Long id);
    Post addPost(Post post);
}
