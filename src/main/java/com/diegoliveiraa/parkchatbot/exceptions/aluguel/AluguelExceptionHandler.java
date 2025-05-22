package com.diegoliveiraa.parkchatbot.exceptions.aluguel;

import com.diegoliveiraa.parkchatbot.exceptions.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class AluguelExceptionHandler {
    @ExceptionHandler(AluguelNotFoundException.class)
    public ResponseEntity<ErrorResponse> handlerAluguelNotFound(AluguelNotFoundException ex){
        ErrorResponse errorResponse = new ErrorResponse(
                HttpStatus.NOT_FOUND.value(),
                ex.getMessage(),
                LocalDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }
    @ExceptionHandler(InvalidAluguelRequestException.class)
    public ResponseEntity<ErrorResponse> handlerInvalidAluguelRequest(InvalidAluguelRequestException ex){
        ErrorResponse errorResponse = new ErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                ex.getMessage(),
                LocalDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }
    @ExceptionHandler(AluguelAlreadyCancelledException.class)
    public ResponseEntity<ErrorResponse> handlerAluguelAlreadyCancelled(AluguelAlreadyCancelledException ex){
        ErrorResponse errorResponse = new ErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                ex.getMessage(),
                LocalDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }
    @ExceptionHandler(AluguelAlreadyConfirmedException.class)
    public ResponseEntity<ErrorResponse> handlerAluguelAlreadyConfirmed(AluguelAlreadyConfirmedException ex){
        ErrorResponse errorResponse = new ErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                ex.getMessage(),
                LocalDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }
}
