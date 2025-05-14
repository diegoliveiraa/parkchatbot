package com.diegoliveiraa.parkchatbot.controllers;

import com.diegoliveiraa.parkchatbot.dtos.vaga.AtribuirProprietarioRequestDTO;
import com.diegoliveiraa.parkchatbot.dtos.vaga.VagaRequestDTO;
import com.diegoliveiraa.parkchatbot.dtos.vaga.VagaResumoDTO;
import com.diegoliveiraa.parkchatbot.services.VagaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/vaga")
public class VagaController {
    @Autowired
    private VagaService vagaService;

    @PostMapping
    public ResponseEntity<VagaResumoDTO> createVaga(@RequestBody VagaRequestDTO requestDTO) throws Exception {
        VagaResumoDTO responseDTO = this.vagaService.createVaga(requestDTO);
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<VagaResumoDTO> updateVaga(@RequestBody VagaRequestDTO requestDTO) throws Exception {
        VagaResumoDTO responseDTO = this.vagaService.updateVaga(requestDTO);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteVaga(@PathVariable UUID id) {
        this.vagaService.deleteVaga(id);
        return new ResponseEntity<>("Vaga excluida com sucesso", HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VagaResumoDTO> getVaga(@PathVariable UUID id) throws Exception {
        VagaResumoDTO responseDTO = this.vagaService.getVaga(id);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<VagaResumoDTO>> getAllVaga() {
        List<VagaResumoDTO> responseDTO = this.vagaService.getAllVaga();
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @PutMapping("/{vagaId}/proprietario")
    public ResponseEntity<VagaResumoDTO> atribuirProprietario(@PathVariable UUID vagaId, @RequestBody AtribuirProprietarioRequestDTO requestDTO) throws Exception {
        log.info("vagasId: {} | moradorId: {}",vagaId, requestDTO.moradorId());
        this.vagaService.atribuirProprietario(vagaId,requestDTO.moradorId());
        VagaResumoDTO responseDTO = this.vagaService.getVaga(vagaId);

        return new ResponseEntity<>(responseDTO, HttpStatus.OK);

    }
}
