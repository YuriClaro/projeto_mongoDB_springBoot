package com.yuriclaro.projetomongospring.resource;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yuriclaro.projetomongospring.domain.User;
import com.yuriclaro.projetomongospring.dto.UserDTO;
import com.yuriclaro.projetomongospring.service.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService service;

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll(){
        List<User> userList = service.findAll();
        List<UserDTO> userDtoList = userList.stream().map(user -> new UserDTO(user))
        .collect(Collectors.toList());

        return ResponseEntity.ok().body(userDtoList);
    } 
    
    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable String id) {
        User obj = service.findById(id);
        
        return ResponseEntity.ok().body(new UserDTO(obj));

    }
}
