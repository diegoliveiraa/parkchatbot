package com.diegoliveiraa.parkchatbot.exceptions.vaga;

import com.diegoliveiraa.parkchatbot.exceptions.ErrorResponse;
import com.diegoliveiraa.parkchatbot.exceptions.morador.InvalidMoradorRequestException;
import com.diegoliveiraa.parkchatbot.exceptions.morador.MoradorNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class VagaExceptionHandler {
    @ExceptionHandler(VagaNotFoundException.class)
    public ResponseEntity<ErrorResponse> handlerVagaNotFound(VagaNotFoundException ex){

        ErrorResponse errorResponse = new ErrorResponse(
                HttpStatus.NOT_FOUND.value(),
                ex.getMessage(),
                LocalDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }
    @ExceptionHandler(InvalidVagaRequestException.class)
    public ResponseEntity<ErrorResponse> handlerVagaInvalidRequest(InvalidVagaRequestException ex){

        ErrorResponse errorResponse = new ErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                ex.getMessage(),
                LocalDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }
    @ExceptionHandler(VagaAlreadyAssignedException.class)
    public ResponseEntity<ErrorResponse> handlerVagaAlreadyAssigned(VagaAlreadyAssignedException ex){

        ErrorResponse errorResponse = new ErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                ex.getMessage(),
                LocalDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }
}
