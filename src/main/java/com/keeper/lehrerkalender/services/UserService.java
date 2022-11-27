package com.keeper.lehrerkalender.services;

import com.keeper.lehrerkalender.persistence.daos.UserRepository;
import com.keeper.lehrerkalender.persistence.daos.UserRoleRepository;
import com.keeper.lehrerkalender.persistence.entities.User;
import com.keeper.lehrerkalender.rest.controllers.dtos.UserCreationDTO;
import com.keeper.lehrerkalender.rest.controllers.enums.RoleEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void populateAndSaveEntity(UserCreationDTO userCreationDTO) {

        User user = new User();

        String username = userCreationDTO.getUsername();
        if (usernameAlreadyExists(username)) {
            throw new IllegalArgumentException("A user with this username already exists.");
        }
        user.setUsername(username);

        String email = userCreationDTO.getEmail();
        if(emailAlreadyExists(email)) {
            throw new IllegalArgumentException("A user with this email already exists.");
        }
        user.setEmail(userCreationDTO.getEmail());

        user.setPassword(passwordEncoder.encode(userCreationDTO.getPassword()));

        var role = userRoleRepository.findUserRoleByName(RoleEnum.TEACHER);

        user.getUserRoles().add(role);
        userRepository.save(user);
    }

    private boolean usernameAlreadyExists(String username) {
        Optional<User> userOptional = userRepository.findByUsername(username);
        return userOptional.isPresent();
    }

    private boolean emailAlreadyExists(String email) {
        Optional<User> userOptional = userRepository.findByEmail(email);
        return userOptional.isPresent();
    }
}
