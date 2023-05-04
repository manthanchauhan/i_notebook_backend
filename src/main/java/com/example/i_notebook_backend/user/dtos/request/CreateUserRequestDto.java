package com.example.i_notebook_backend.user.dtos.request;

import com.example.i_notebook_backend.auth.validators.ValidPassword;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class CreateUserRequestDto {
    @Pattern(regexp = "^[a-zA-Z]{3,101}$", message = "Invalid firstName")
    @NotNull(message = "firstName is missing")
    private String firstName;

    @Pattern(regexp = "^[a-zA-Z]{3,101}$", message = "Invalid lastName")
    private String lastName;

    @NotNull(message = "email is missing")
    @Pattern(regexp = "^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$", message = "Invalid email")
    private String email;

    @ValidPassword
    private String password;
}
