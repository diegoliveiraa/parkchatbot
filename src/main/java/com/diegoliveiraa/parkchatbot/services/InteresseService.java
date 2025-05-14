package com.diegoliveiraa.parkchatbot.services;

import com.diegoliveiraa.parkchatbot.dtos.interesse.InteresseRequestDTO;
import com.diegoliveiraa.parkchatbot.dtos.interesse.InteresseResponseDTO;
import com.diegoliveiraa.parkchatbot.entitys.Aluguel;
import com.diegoliveiraa.parkchatbot.entitys.Interesse;
import com.diegoliveiraa.parkchatbot.entitys.Morador;
import com.diegoliveiraa.parkchatbot.mappers.InteressadoMapper;
import com.diegoliveiraa.parkchatbot.repositories.InteresseRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class InteresseService {

    @Autowired
    private InteresseRepository interesseRepository;
    @Autowired
    private AluguelService aluguelService;
    @Autowired
    private MoradadorService moradadorService;

    public InteresseResponseDTO createInterestAluguel(InteresseRequestDTO dto) throws Exception {
        Aluguel aluguel = this.aluguelService.getEntidade(dto.aluguelId());
        Morador interessado = this.moradadorService.getEntidade(dto.interessado());

        Interesse interesse = new Interesse();
        interesse.setAluguel(aluguel);
        interesse.setInteressado(interessado);
        interesse.setDataInteresse(LocalDateTime.now());

        this.interesseRepository.save(interesse);

        return InteressadoMapper.toDTO(interesse);
    }

    public Interesse getEntidade(UUID id){
        return this.interesseRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Interesse não encontrado"));
    }
}
