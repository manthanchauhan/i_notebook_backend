package com.example.i_notebook_backend.auth.validators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.regex.Pattern;

public class PasswordConstraintValidator implements ConstraintValidator<ValidPassword, String > {
    private final Pattern passwordRegex = Pattern.compile("^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$");

    @Override
    public boolean isValid(String s, ConstraintValidatorContext context) {
        if (s == null || s.isEmpty()){
            context.buildConstraintViolationWithTemplate("Password is missing.").addConstraintViolation();
            return false;
        }

        if (passwordRegex.matcher(s).matches()){
            return true;
        }

        context.buildConstraintViolationWithTemplate("""
                    Password must contain:
                    1. At least 1 upper case letter.
                    2. At least 1 lower case letter.
                    3. At least one number.
                    4. At least one of [#?!@$%^&*-].
                    5. Minimum 8 characters.
                    """).addConstraintViolation();
        return false;
    }
}
