package com.yuriclaro.projetomongospring.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.yuriclaro.projetomongospring.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
    
}