package com.example.blog.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class AwesomeExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(AuthenticationException.class)
    protected ResponseEntity<AwesomeException> handleBadCredentialException() {
        return new ResponseEntity<>(new AwesomeException("User or password not valid"), HttpStatus.NOT_FOUND);
    }


    @Data
    @AllArgsConstructor
    private static class AwesomeException {

        private String message;

    }

}
