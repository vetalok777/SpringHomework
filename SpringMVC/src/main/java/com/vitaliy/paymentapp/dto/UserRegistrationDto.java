package com.vitaliy.paymentapp.dto;


import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.*;

@Data
@Builder
public class UserRegistrationDto {
    @Email(message = "Should be valid email")
    @NotBlank(message = "Login field must be not empty")
    private String login;
    @Min(value = 8, message = "Password should be at least 8 characters")
    @NotEmpty(message = "Password field must be not empty")
    private String password;
    @NotEmpty(message = "Firstname field must be not empty")
    @Size(min = 1, max = 15, message = "FirstName must be 15 characters max")
    private String firstName;
}
