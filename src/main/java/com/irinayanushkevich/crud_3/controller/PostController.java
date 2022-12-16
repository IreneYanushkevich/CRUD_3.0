package com.irinayanushkevich.crud_3.controller;

import com.irinayanushkevich.crud_3.model.Label;
import com.irinayanushkevich.crud_3.model.Post;
import com.irinayanushkevich.crud_3.service.PostService;


import java.time.LocalDateTime;
import java.util.List;

public class PostController {
    private final PostService postService = new PostService();

    public Post create(String content, List<Label> labels) {
        Post post = new Post(null, content, null, labels);
        return postService.create(post);
    }

    public Post getById(Long id) {
        return postService.getById(id);
    }

    public Post edit(Long id, String content, LocalDateTime created, List<Label> labels) {
        Post post = new Post(id, content, created, labels);
        return postService.edit(post);
    }

    public boolean delete(Long id) {
        return postService.delete(id);
    }

    public List<Post> getAll() {
        return postService.getAll();
    }
}