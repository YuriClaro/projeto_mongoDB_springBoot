package com.yuriclaro.projetomongospring.service;

import java.util.Optional;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yuriclaro.projetomongospring.domain.Post;
import com.yuriclaro.projetomongospring.repository.PostRepository;
import com.yuriclaro.projetomongospring.service.exception.ObjectNotFoundException;

@Service
public class PostService {
    
    @Autowired
    private PostRepository postRepository;

    public Post findById(String id) {
        Optional<Post> post = postRepository.findById(id);
        return post.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado!"));
    }

    public List<Post> findByTitle(String text) {
		return postRepository.searchTitle(text);
    }
}