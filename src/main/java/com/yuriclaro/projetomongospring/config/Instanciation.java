package com.yuriclaro.projetomongospring.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.yuriclaro.projetomongospring.domain.User;
import com.yuriclaro.projetomongospring.repository.UserRepository;

@Configuration
public class Instanciation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        userRepository.deleteAll();

        User yuri = new User(null, "Yuri Claro", "yuriclaro@email.com");
        User milena = new User(null, "Milena Carvalho", "milenacarvalho@email.com");
        User marcus = new User(null, "Marcus Mesquita", "marcusmesquita@email.com");
        userRepository.saveAll(Arrays.asList(yuri, milena, marcus));
   }
    
}