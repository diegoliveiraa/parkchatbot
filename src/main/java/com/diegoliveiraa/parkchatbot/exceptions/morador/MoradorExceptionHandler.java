package com.diegoliveiraa.parkchatbot.exceptions.morador;

import com.diegoliveiraa.parkchatbot.exceptions.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class MoradorExceptionHandler{

    @ExceptionHandler(MoradorNotFoundException.class)
    public ResponseEntity<ErrorResponse> handlerMoradorNotFound(MoradorNotFoundException ex){

        ErrorResponse errorResponse = new ErrorResponse(
                HttpStatus.NOT_FOUND.value(),
                ex.getMessage(),
                LocalDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }
    @ExceptionHandler(InvalidMoradorRequestException.class)
    public ResponseEntity<ErrorResponse> handlerMoradorInvalidRequest(InvalidMoradorRequestException ex){

        ErrorResponse errorResponse = new ErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                ex.getMessage(),
                LocalDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }
}
