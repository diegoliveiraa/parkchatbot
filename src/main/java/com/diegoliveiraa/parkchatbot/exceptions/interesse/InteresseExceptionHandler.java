package com.diegoliveiraa.parkchatbot.exceptions.interesse;


import com.diegoliveiraa.parkchatbot.exceptions.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class InteresseExceptionHandler {
    @ExceptionHandler(InteresseNotFoundException.class)
    public ResponseEntity<ErrorResponse> handlerInteresseNotFound(InteresseNotFoundException ex){
        ErrorResponse errorResponse = new ErrorResponse(
                HttpStatus.NOT_FOUND.value(),
                ex.getMessage(),
                LocalDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }
    @ExceptionHandler(InteresseAlreadyApprovedException.class)
    public ResponseEntity<ErrorResponse> handlerInteresseAlreadyApproved(InteresseAlreadyApprovedException ex){
        ErrorResponse errorResponse = new ErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                ex.getMessage(),
                LocalDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }
    @ExceptionHandler(InteresseAlreadyCancelledException.class)
    public ResponseEntity<ErrorResponse> handlerInteresseAlreadyCancelled(InteresseAlreadyCancelledException ex){
        ErrorResponse errorResponse = new ErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                ex.getMessage(),
                LocalDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }
    @ExceptionHandler(InteresseAlreadyExistException.class)
    public ResponseEntity<ErrorResponse> handlerInteresseAlreadyExist(InteresseAlreadyExistException ex){
        ErrorResponse errorResponse = new ErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                ex.getMessage(),
                LocalDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }
    @ExceptionHandler(InteresseInvalidOperationException.class)
    public ResponseEntity<ErrorResponse> handlerInteresseInvalidOperation(InteresseInvalidOperationException ex){
        ErrorResponse errorResponse = new ErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                ex.getMessage(),
                LocalDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }
}