package com.yuriclaro.projetomongospring.resource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yuriclaro.projetomongospring.domain.User;

@RestController
@RequestMapping(value="/users")
public class UserResource {

    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        User yuri = new User("1", "Yuri Claro", "yuriclaro@outlook.com");
        User milena = new User("2", "Milena Carvalho", "milenacarvalho@gmail.com");
    
        List<User> users = new ArrayList<>();
        users.addAll(Arrays.asList(yuri, milena));
        
        return ResponseEntity.ok().body(users);
    }
    
}
