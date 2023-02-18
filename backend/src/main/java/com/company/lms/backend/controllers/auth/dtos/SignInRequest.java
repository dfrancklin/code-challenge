package com.company.lms.backend.controllers.auth.dtos;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class SignInRequest {

    @Email(message = "A valid email address must be informed")
    @NotBlank(message = "Email must be informed")
    private String email;

    @NotBlank(message = "Password must be informed")
    private String password;

}
