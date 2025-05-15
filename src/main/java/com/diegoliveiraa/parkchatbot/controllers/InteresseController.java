package com.diegoliveiraa.parkchatbot.controllers;

import com.diegoliveiraa.parkchatbot.dtos.interesse.InteresseRequestDTO;
import com.diegoliveiraa.parkchatbot.dtos.interesse.InteresseResponseDTO;
import com.diegoliveiraa.parkchatbot.services.InteresseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/interesse")
public class InteresseController {
    @Autowired
    private InteresseService interesseService;

    @PostMapping
    public ResponseEntity<InteresseResponseDTO> createInterest(@RequestBody InteresseRequestDTO dto) throws Exception {
        InteresseResponseDTO responseDTO = this.interesseService.createInterestAluguel(dto);
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    @PutMapping("/{id}/cancelar")
    public ResponseEntity<InteresseResponseDTO> cancelInteresse(@PathVariable UUID id){
        InteresseResponseDTO responseDTO = this.interesseService.cancelInteresse(id);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<InteresseResponseDTO>> getAllInteresse(){
        List<InteresseResponseDTO> responseDTO = this.interesseService.getAllInteresse();
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
}
