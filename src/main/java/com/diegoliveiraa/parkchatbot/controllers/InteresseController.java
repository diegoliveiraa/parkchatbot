package com.diegoliveiraa.parkchatbot.controllers;

import com.diegoliveiraa.parkchatbot.dtos.interesse.InteresseRequestDTO;
import com.diegoliveiraa.parkchatbot.dtos.interesse.InteresseResponseDTO;
import com.diegoliveiraa.parkchatbot.services.InteresseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
