package com.diegoliveiraa.parkchatbot.controllers;

import com.diegoliveiraa.parkchatbot.dtos.aluguel.AluguelRequestDTO;
import com.diegoliveiraa.parkchatbot.dtos.aluguel.AluguelResponseDTO;
import com.diegoliveiraa.parkchatbot.services.AluguelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/aluguel")
public class AluguelController {
    @Autowired
    private AluguelService aluguelService;

    @PostMapping
    public ResponseEntity<AluguelResponseDTO> createAluguel(@RequestBody AluguelRequestDTO dto) throws Exception {
        AluguelResponseDTO responseDTO = this.aluguelService.createAluguel(dto);
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }
}
