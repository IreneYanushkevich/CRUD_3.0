package com.irinayanushkevich.crud_3.service;

import com.irinayanushkevich.crud_3.model.Post;
import com.irinayanushkevich.crud_3.repository.PostRepository;
import com.irinayanushkevich.crud_3.repository.hib_rep.HibPostRepositoryImpl;

import java.util.List;

public class PostService {
    private final PostRepository postRep;

    public PostService() {
        postRep = new HibPostRepositoryImpl();
    }

    public PostService(PostRepository postRep) {
        this.postRep = postRep;
    }

    public Post create(Post post) {
        return postRep.create(post);
    }

    public Post getById(Long id) {
        return postRep.getById(id);
    }

    public Post edit(Post post) {
        return postRep.edit(post);
    }

    public boolean delete(Long id) {
        return postRep.delete(id);
    }

    public List<Post> getAll() {
        return postRep.getAll();
    }
}
