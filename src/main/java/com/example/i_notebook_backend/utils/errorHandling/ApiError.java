package com.example.i_notebook_backend.utils.errorHandling;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@JsonSerialize(using = ApiErrorSerializer.class)
public class ApiError {

    private HttpStatus status;
    private String message;

    public ApiError(HttpStatus status, String message) {
        super();
        this.status = status;
        this.message = message;
    }
}