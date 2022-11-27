package com.keeper.lehrerkalender.rest.controllers;

import com.keeper.lehrerkalender.persistence.daos.UserRepository;
import com.keeper.lehrerkalender.persistence.daos.UserRoleRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "test")
@RestController
@RequestMapping(path = "/test")
public class TestController {

    @Operation(summary = "Get a test", security = {@SecurityRequirement(name = "bearer-key")})
    @ApiResponses({
            @ApiResponse(responseCode = "400", description = "Invalid id supplied.", content = @Content),
            @ApiResponse(responseCode = "403", description = "You are not authorized.", content = @Content),
            @ApiResponse(responseCode = "404", description = "Test not found.", content = @Content)
    })
    @PreAuthorize("hasAnyAuthority('TEACHER')")
    @GetMapping
    public String test() {
        return "hellooooooo";
    }
}
