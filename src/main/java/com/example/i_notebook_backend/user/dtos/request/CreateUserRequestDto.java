package com.example.i_notebook_backend.user.dtos.request;

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

    @NotNull(message = "password is missing")
    @Pattern(regexp = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$",
            message = """
                    Password must contain:
                    1. At least 1 upper case letter.
                    2. At least 1 lower case letter.
                    3. At least one number.
                    4. At least one of [#?!@$%^&*-].
                    5. Minimum 8 characters.
                    """)
    private String password;
}
