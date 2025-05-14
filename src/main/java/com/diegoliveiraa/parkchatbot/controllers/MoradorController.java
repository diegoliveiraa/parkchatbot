package com.diegoliveiraa.parkchatbot.controllers;

import com.diegoliveiraa.parkchatbot.dtos.morador.MoradorRequestDTO;
import com.diegoliveiraa.parkchatbot.dtos.morador.MoradorResponseDTO;
import com.diegoliveiraa.parkchatbot.services.MoradadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/morador")
public class MoradorController {

    @Autowired
    private MoradadorService moradadorService;

    @PostMapping
    public ResponseEntity<MoradorResponseDTO> createMorador(@RequestBody MoradorRequestDTO requestDTO) {
        MoradorResponseDTO responseDTO = this.moradadorService.createMorador(requestDTO);
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<MoradorResponseDTO> updateMorador(@RequestBody MoradorRequestDTO requestDTO) {
        MoradorResponseDTO responseDTO = this.moradadorService.updateMorador(requestDTO);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteMorador(@PathVariable UUID id) {
        this.moradadorService.deleteMorador(id);
        return new ResponseEntity<>("Morador excluido com sucesso", HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MoradorResponseDTO> getMorador(@PathVariable UUID id) throws Exception {
        MoradorResponseDTO responseDTO = this.moradadorService.getMorador(id);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<MoradorResponseDTO>> getAllMorador() {
        List<MoradorResponseDTO> responseDTO = this.moradadorService.getAllMorador();
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

}
