package com.keeper.lehrerkalender.rest.controllers;

import com.keeper.lehrerkalender.rest.controllers.dtos.UserLoginDTO;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Authentication")
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    AuthenticationManager authenticationManager;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserLoginDTO user) {
        String username = user.getUsername();
        String password = user.getPassword();

        try {
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
            if (authentication.isAuthenticated()) {

                //TODO generate Token and extact logic in own method
                return ResponseEntity.ok("token");
            } else {
                return ResponseEntity.status(401).body("wrong");
            }
        } catch (BadCredentialsException e) {
            return ResponseEntity.status(401).body("exc");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("exc5");
        }
    }
}
