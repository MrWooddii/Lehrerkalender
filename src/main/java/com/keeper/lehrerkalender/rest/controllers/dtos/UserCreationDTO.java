package com.keeper.lehrerkalender.rest.controllers.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserCreationDTO {

    @Schema(description = "Username of the new user", example = "Steve")
    private String username;

    @Schema(description = "Email of the new user", example = "email@mail.de")
    private String email;

    @Schema(description = "Password of the new user", example = "password")
    private String password;
}
