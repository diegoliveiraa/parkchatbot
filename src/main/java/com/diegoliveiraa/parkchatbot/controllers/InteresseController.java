package com.diegoliveiraa.parkchatbot.controllers;

import com.diegoliveiraa.parkchatbot.dtos.interesse.InteresseRequestDTO;
import com.diegoliveiraa.parkchatbot.dtos.interesse.InteresseResponseDTO;
import com.diegoliveiraa.parkchatbot.services.InteresseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Tag(name = "Interesses", description = "Operações relacionadas a interesses em alugueis")
@RestController
@RequestMapping("/interesse")
public class InteresseController {
    @Autowired
    private InteresseService interesseService;

    @Operation(summary = "Cria um interesse em um aluguel")
    @PostMapping
    public ResponseEntity<InteresseResponseDTO> createInteresse(@RequestBody InteresseRequestDTO dto) throws Exception {
        InteresseResponseDTO responseDTO = this.interesseService.createInterestAluguel(dto);
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    @Operation(summary = "Altera o status de um interesse para Cancelado")
    @PutMapping("/{id}/cancelar")
    public ResponseEntity<InteresseResponseDTO> cancelInteresse(@PathVariable UUID id) {
        InteresseResponseDTO responseDTO = this.interesseService.cancelInteresse(id);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @Operation(summary = "Retorna todos os interesses")
    @GetMapping
    public ResponseEntity<List<InteresseResponseDTO>> getAllInteresse() {
        List<InteresseResponseDTO> responseDTO = this.interesseService.getAllInteresse();
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
}
