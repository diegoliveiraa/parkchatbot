package com.diegoliveiraa.parkchatbot.controllers;

import com.diegoliveiraa.parkchatbot.dtos.vaga.AtribuirProprietarioRequestDTO;
import com.diegoliveiraa.parkchatbot.dtos.vaga.VagaRequestDTO;
import com.diegoliveiraa.parkchatbot.dtos.vaga.VagaResumoDTO;
import com.diegoliveiraa.parkchatbot.services.VagaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Tag(name = "Vagas", description = "Operações relacionadas a vagas")
@Slf4j
@RestController
@RequestMapping("/vagas")
public class VagaController {
    @Autowired
    private VagaService vagaService;

    @Operation(summary = "Cria uma nova vaga")
    @PostMapping
    public ResponseEntity<VagaResumoDTO> createVaga(@RequestBody VagaRequestDTO requestDTO) throws Exception {
        VagaResumoDTO responseDTO = this.vagaService.createVaga(requestDTO);
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    @Operation(summary = "Atualiza uma vaga")
    @PutMapping("{id}/atualizar-dados-vaga")
    public ResponseEntity<VagaResumoDTO> updateVaga(@PathVariable UUID id, @RequestBody VagaRequestDTO requestDTO) throws Exception {
        VagaResumoDTO responseDTO = this.vagaService.updateVaga(id, requestDTO);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @Operation(summary = "Exclui uma vaga")
    @DeleteMapping("/{id}")
    public ResponseEntity deleteVaga(@PathVariable UUID id) throws Exception {
        this.vagaService.deleteVaga(id);
        return new ResponseEntity<>("Vaga excluida com sucesso", HttpStatus.OK);
    }

    @Operation(summary = "Retorna uma vaga")
    @GetMapping("/{id}")
    public ResponseEntity<VagaResumoDTO> getVaga(@PathVariable UUID id) throws Exception {
        VagaResumoDTO responseDTO = this.vagaService.getVaga(id);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @Operation(summary = "Retorna todas as vaga")
    @GetMapping
    public ResponseEntity<List<VagaResumoDTO>> getAllVaga() {
        List<VagaResumoDTO> responseDTO = this.vagaService.getAllVaga();
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @Operation(summary = "Atribui uma vaga a um morador")
    @PutMapping("/{vagaId}/proprietario")
    public ResponseEntity<VagaResumoDTO> atribuirProprietario(@PathVariable UUID vagaId, @RequestBody AtribuirProprietarioRequestDTO requestDTO) throws Exception {
        log.info("vagasId: {} | moradorId: {}", vagaId, requestDTO.moradorId());
        this.vagaService.atribuirProprietario(vagaId, requestDTO.moradorId());
        VagaResumoDTO responseDTO = this.vagaService.getVaga(vagaId);

        return new ResponseEntity<>(responseDTO, HttpStatus.OK);

    }
}
