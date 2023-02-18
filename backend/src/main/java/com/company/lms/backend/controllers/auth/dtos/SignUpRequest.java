package com.company.lms.backend.controllers.auth.dtos;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SignUpRequest {

    @NotBlank(message = "First Name must be informed")
    private String firstName;

    @NotBlank(message = "Last Name must be informed")
    private String lastName;

    @NotNull(message = "Date of Birth must be informed")
    private LocalDate birthDate;

    @NotBlank(message = "Address must be informed")
    private String address;

    @NotBlank(message = "City must be informed")
    private String city;

    @NotBlank(message = "State must be informed")
    private String state;

    @NotBlank(message = "Zip Code must be informed")
    private String zipCode;

    @Email(message = "A valid email address must be informed")
    @NotBlank(message = "Email must be informed")
    private String email;

    @NotBlank(message = "Phone Number must be informed")
    private String phoneNumber;

    @NotBlank(message = "Password must be informed")
    private String password;

}
