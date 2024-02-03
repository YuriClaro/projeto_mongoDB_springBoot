package com.yuriclaro.projetomongospring.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.yuriclaro.projetomongospring.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    
}
