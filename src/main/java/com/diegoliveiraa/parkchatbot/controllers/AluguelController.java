package com.diegoliveiraa.parkchatbot.controllers;

import com.diegoliveiraa.parkchatbot.dtos.aluguel.requests.AluguelOfferRequestDTO;
import com.diegoliveiraa.parkchatbot.dtos.aluguel.requests.ConfirmAluguelRequestDTO;
import com.diegoliveiraa.parkchatbot.dtos.aluguel.responses.AluguelResponseDTO;
import com.diegoliveiraa.parkchatbot.dtos.aluguel.responses.ConfirmedAluguelResponseDTO;
import com.diegoliveiraa.parkchatbot.services.AluguelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/aluguel")
public class AluguelController {
    @Autowired
    private AluguelService aluguelService;

    @PostMapping("/oferta")
    public ResponseEntity<AluguelResponseDTO> createOfferAluguel(@RequestBody AluguelOfferRequestDTO dto) throws Exception {
        AluguelResponseDTO responseDTO = this.aluguelService.createOfferAluguel(dto);
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    @PostMapping("/confirmar")
    public ResponseEntity<ConfirmedAluguelResponseDTO> confirmOfferAluguel(@RequestBody ConfirmAluguelRequestDTO dto) throws Exception {
        ConfirmedAluguelResponseDTO responseDTO = this.aluguelService.confirmAluguel(dto);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @PutMapping("/{aluguelId}/encerrar")
    public ResponseEntity<AluguelResponseDTO> cancelAluguel(@PathVariable UUID aluguelId) {
        AluguelResponseDTO responseDTO = this.aluguelService.cancelAluguel(aluguelId);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<AluguelResponseDTO>> getAllAlugueis() {
        List<AluguelResponseDTO> responseDTO = this.aluguelService.getAluguelDisponivel();
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

}