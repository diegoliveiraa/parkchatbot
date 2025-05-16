package com.diegoliveiraa.parkchatbot.controllers;

import com.diegoliveiraa.parkchatbot.dtos.aluguel.requests.AluguelOfferRequestDTO;
import com.diegoliveiraa.parkchatbot.dtos.aluguel.requests.ConfirmAluguelRequestDTO;
import com.diegoliveiraa.parkchatbot.dtos.aluguel.responses.AluguelResponseDTO;
import com.diegoliveiraa.parkchatbot.dtos.aluguel.responses.ConfirmedAluguelResponseDTO;
import com.diegoliveiraa.parkchatbot.services.AluguelService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Tag(name = "Alugueis", description = "Operações relacionadas a aluguéis de vagas")
@RestController
@RequestMapping("/aluguel")
public class AluguelController {
    @Autowired
    private AluguelService aluguelService;

    @Operation(summary = "Cria uma oferta de aluguel")
    @PostMapping("/oferta")
    public ResponseEntity<AluguelResponseDTO> createOfferAluguel(@RequestBody AluguelOfferRequestDTO dto) throws Exception {
        AluguelResponseDTO responseDTO = this.aluguelService.createOfferAluguel(dto);
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }
    @Operation(summary = "Confirma um aluguel com base no interesse aprovado")
    @PostMapping("/confirmar")
    public ResponseEntity<ConfirmedAluguelResponseDTO> confirmOfferAluguel(@RequestBody ConfirmAluguelRequestDTO dto) throws Exception {
        ConfirmedAluguelResponseDTO responseDTO = this.aluguelService.confirmAluguel(dto);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
    @Operation(summary = "Encerra um aluguel pelo morador")
    @PutMapping("/{aluguelId}/encerrar")
    public ResponseEntity<AluguelResponseDTO> cancelAluguel(@PathVariable UUID aluguelId) {
        AluguelResponseDTO responseDTO = this.aluguelService.cancelAluguel(aluguelId);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
    @Operation(summary = "Retorna todos os alugueis disponiveis")
    @GetMapping
    public ResponseEntity<List<AluguelResponseDTO>> getAlugueisDisponiveis() {
        List<AluguelResponseDTO> responseDTO = this.aluguelService.getAluguelDisponivel();
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
    @Operation(summary = "Retorna todos os alugueis ")
    @GetMapping("/todos")
    public ResponseEntity<List<AluguelResponseDTO>> getAlugueis() {
        List<AluguelResponseDTO> responseDTO = this.aluguelService.getAllAluguel();
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

}