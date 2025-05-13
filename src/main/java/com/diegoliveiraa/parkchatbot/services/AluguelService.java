package com.diegoliveiraa.parkchatbot.services;

import com.diegoliveiraa.parkchatbot.dtos.AluguelResponseDTO;
import com.diegoliveiraa.parkchatbot.entitys.Aluguel;
import com.diegoliveiraa.parkchatbot.repositories.AluguelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AluguelService {
    @Autowired
    private AluguelRepository aluguelRepository;
    public Aluguel getVagaAlugada(UUID uuid) {

        return this.aluguelRepository.findById(uuid).orElseThrow(()-> new RuntimeException("Vagas não encontrada"));
    }
}
