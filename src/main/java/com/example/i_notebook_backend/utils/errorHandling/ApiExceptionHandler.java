package com.example.i_notebook_backend.utils.errorHandling;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;

@ControllerAdvice
// https://www.baeldung.com/global-error-handler-in-a-spring-rest-api
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex,
            HttpHeaders headers,
            HttpStatusCode status,
            WebRequest request) {
        String errorMessage = this.extractErrorMessageMethodArgumentNotValid(ex);

        ApiError apiError =
                new ApiError(HttpStatus.BAD_REQUEST, errorMessage);
        return handleExceptionInternal(
                ex, apiError, headers, apiError.getStatus(), request);
    }

    @Override
    protected ResponseEntity<Object> handleMissingServletRequestParameter(
            MissingServletRequestParameterException ex, HttpHeaders headers,
            HttpStatusCode status, WebRequest request) {
        ApiError apiError =
                new ApiError(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage());
        return new ResponseEntity<>(
                apiError, new HttpHeaders(), apiError.getStatus());
    }

    @ExceptionHandler(value = { ResponseStatusException.class})
    protected ResponseEntity<Object> handleResponseStatusException(ResponseStatusException ex, WebRequest request) {
        ApiError apiError = new ApiError((HttpStatus) ex.getStatusCode(), ex.getReason());

        return handleExceptionInternal(ex, apiError, new HttpHeaders(), ex.getStatusCode(), request);
    }

    private String extractErrorMessageMethodArgumentNotValid(MethodArgumentNotValidException ex){
        List<ObjectError> errorList = ex.getBindingResult().getAllErrors();
        String errorMessage = null;

        if (!errorList.isEmpty()){
            ObjectError firstError = errorList.get(0);
            errorMessage = firstError.getDefaultMessage();
        }

        return errorMessage == null ? "Something went wrong" : errorMessage;
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Object> handleAllUncaughtException(RuntimeException exception, WebRequest request){
        ApiError apiError = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
        return handleExceptionInternal(exception, apiError, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
    }
}
