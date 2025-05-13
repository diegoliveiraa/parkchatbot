package com.diegoliveiraa.parkchatbot.controllers;

import com.diegoliveiraa.parkchatbot.dtos.MoradorResponseDTO;
import com.diegoliveiraa.parkchatbot.dtos.VagaRequestDTO;
import com.diegoliveiraa.parkchatbot.dtos.VagaResponseDTO;
import com.diegoliveiraa.parkchatbot.services.VagaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/vaga")
public class VagaController {
    @Autowired
    private VagaService vagaService;

    @PostMapping
    public ResponseEntity<VagaResponseDTO> createVaga(@RequestBody VagaRequestDTO requestDTO) {
        VagaResponseDTO responseDTO = this.vagaService.createVaga(requestDTO);
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<VagaResponseDTO> updateVaga(@RequestBody VagaRequestDTO requestDTO) {
        VagaResponseDTO responseDTO = this.vagaService.updateVaga(requestDTO);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteVaga(@PathVariable UUID id) {
        this.vagaService.deleteVaga(id);
        return new ResponseEntity<>("Vaga excluida com sucesso", HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VagaResponseDTO> getVaga(@PathVariable UUID id) throws Exception {
        VagaResponseDTO responseDTO = this.vagaService.vaga(id);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<MoradorResponseDTO>> getAllMorador() {
        List<MoradorResponseDTO> responseDTO = this.vagaService.getAllMorador();
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
}
