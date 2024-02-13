package com.yuriclaro.projetomongospring.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.yuriclaro.projetomongospring.domain.Post;
import com.yuriclaro.projetomongospring.domain.User;
import com.yuriclaro.projetomongospring.dto.AuthorDTO;
import com.yuriclaro.projetomongospring.dto.CommentDTO;
import com.yuriclaro.projetomongospring.repository.PostRepository;
import com.yuriclaro.projetomongospring.repository.UserRepository;

@Configuration
public class Instanciation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();
        postRepository.deleteAll();
        

        User yuri = new User(null, "Yuri Claro", "yuriclaro@email.com");
        User milena = new User(null, "Milena Carvalho", "milenacarvalho@email.com");
        User marcus = new User(null, "Marcus Mesquita", "marcusmesquita@email.com");
        
        Post post1 = new Post(
            null, 
            sdf.parse("21/03/2018"),
            "Partiu viagem!",
            "Vou viajar para São Paulo",
            new AuthorDTO(milena)
        );
        userRepository.saveAll(Arrays.asList(yuri, milena, marcus));
        
        Post post2 = new Post(
            null,
            sdf.parse("23/03/2018"),
            "Bom dia!",
            "Acordei feliz hoje!",
            new AuthorDTO(milena)
        );

        CommentDTO c1 = new CommentDTO("Boa viagem mano!", sdf.parse("2018/03/21"), new AuthorDTO(yuri));
        CommentDTO c2 = new CommentDTO("Aproveite!", sdf.parse("2018/03/22"), new AuthorDTO(marcus));
        CommentDTO c3 = new CommentDTO("Tenha um ótimo dia!", sdf.parse("2018/03/23"), new AuthorDTO(yuri));
        post1.getComments().addAll(Arrays.asList(c1, c2));
        post2.getComments().addAll(Arrays.asList(c3));
              
        postRepository.saveAll(Arrays.asList(post1, post2));
   }
}