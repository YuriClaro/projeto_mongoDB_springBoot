package com.yuriclaro.projetomongospring.dto;

import java.io.Serializable;

import com.yuriclaro.projetomongospring.domain.User;

public class UserDTO implements Serializable {
    private String id;
    private String name;
    private String email;

    public UserDTO(){
    }

    public UserDTO(User user) {
        id = user.id();
        name = user.name();
        email = user.email();
    }

    public UserDTO(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }   
}