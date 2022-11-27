package com.keeper.lehrerkalender;

import com.keeper.lehrerkalender.rest.controllers.dtos.UserCreationDTO;
import com.keeper.lehrerkalender.rest.controllers.enums.RoleEnum;
import com.keeper.lehrerkalender.persistence.daos.UserRepository;
import com.keeper.lehrerkalender.persistence.daos.UserRoleRepository;
import com.keeper.lehrerkalender.persistence.entities.User;
import com.keeper.lehrerkalender.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class LehrerkalenderApplication {

    public static void main(String[] args) {
        SpringApplication.run(LehrerkalenderApplication.class, args);
    }

    //TODO use service
//    @Bean
//    CommandLineRunner init(UserService userService) {
//        return args -> Stream.of("Steve", "Becci").forEach(name -> {
//
//            UserCreationDTO user = new UserCreationDTO();
//            user.setUsername(name);
//            user.setPassword("password");
//            user.setEmail(name.toLowerCase() + "@mail.de");
//            userService.populateAndSaveEntity(user);
//        });
//    }

}
