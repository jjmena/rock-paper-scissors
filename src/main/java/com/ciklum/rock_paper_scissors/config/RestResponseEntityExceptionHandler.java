package com.ciklum.rock_paper_scissors.config;

import com.ciklum.rock_paper_scissors.controller.UserNotExistException;
import com.ciklum.rock_paper_scissors.domain.Error;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(UserNotExistException.class)
    protected ResponseEntity<Error> handleUserNotExistException(UserNotExistException ex) {
        return ResponseEntity.badRequest().body(Error.builder().reason(String.format("User %s doesn't exist", ex.getUserId())).build());
    }
}
