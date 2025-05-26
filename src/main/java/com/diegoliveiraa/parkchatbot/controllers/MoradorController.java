package com.diegoliveiraa.parkchatbot.controllers;

import com.diegoliveiraa.parkchatbot.dtos.morador.MoradorRequestDTO;
import com.diegoliveiraa.parkchatbot.dtos.morador.MoradorResponseDTO;
import com.diegoliveiraa.parkchatbot.services.MoradorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
@Tag(name = "Moradores", description = "Operações relacionadas a moradores")
@RestController
@RequestMapping("/morador")
public class MoradorController {

    @Autowired
    private MoradorService moradorService;

    @Operation(summary = "Cria um novo moradores")
    @PostMapping
    public ResponseEntity<MoradorResponseDTO> createMorador(@RequestBody MoradorRequestDTO requestDTO) {
        MoradorResponseDTO responseDTO = this.moradorService.createMorador(requestDTO);
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    @Operation(summary = "Atualiza dados de um morador")
    @PutMapping("{id}/atualizar-dados")
    public ResponseEntity<MoradorResponseDTO> updateMorador(@PathVariable UUID id, @RequestBody MoradorRequestDTO requestDTO) {
        MoradorResponseDTO responseDTO = this.moradorService.updateMorador(id, requestDTO);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @Operation(summary = "Exclui um morador com base no id")
    @DeleteMapping("/{id}")
    public ResponseEntity deleteMorador(@PathVariable UUID id) {
        this.moradorService.deleteMorador(id);
        return new ResponseEntity<>("Morador excluido com sucesso", HttpStatus.OK);
    }

    @Operation(summary = "Retorna um morador com base no id")
    @GetMapping("/{id}")
    public ResponseEntity<MoradorResponseDTO> getMorador(@PathVariable UUID id) throws Exception {
        MoradorResponseDTO responseDTO = this.moradorService.getMorador(id);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @Operation(summary = "Retorna todos os Moradores")
    @GetMapping
    public ResponseEntity<List<MoradorResponseDTO>> getAllMorador() {
        List<MoradorResponseDTO> responseDTO = this.moradorService.getAllMorador();
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

}
