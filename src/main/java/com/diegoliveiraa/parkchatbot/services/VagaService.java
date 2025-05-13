package com.diegoliveiraa.parkchatbot.services;

import com.diegoliveiraa.parkchatbot.dtos.VagaRequestDTO;
import com.diegoliveiraa.parkchatbot.dtos.VagaResponseDTO;
import com.diegoliveiraa.parkchatbot.entitys.Vaga;
import com.diegoliveiraa.parkchatbot.repositories.VagaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class VagaService {

    @Autowired
    private VagaRepository vagaRepository;

    public Vaga getVaga(UUID id) {

        Vaga vaga = this.vagaRepository.findById(id).orElseThrow(() -> new RuntimeException("Vaga nao encontrada"));
        return vaga;
    }

    public VagaResponseDTO vaga(UUID id) {
        Vaga vaga = this.getVaga(id);

        return new VagaResponseDTO(
                vaga.getNumeroVaga(),
                vaga.getValorMensal(),
                vaga.isDisponibilidade(),
                vaga.getProprietario(),
                vaga.getLocatario(),
                vaga.getDataAluguel());
    }

    public VagaResponseDTO createVaga(VagaRequestDTO dto) {

        Vaga newVaga = new Vaga(dto);
    }
}
