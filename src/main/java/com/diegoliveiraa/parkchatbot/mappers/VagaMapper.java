package com.diegoliveiraa.parkchatbot.mappers;

import com.diegoliveiraa.parkchatbot.dtos.VagaResponseDTO;
import com.diegoliveiraa.parkchatbot.entitys.Vaga;

import java.util.Collections;

public class VagaMapper {
    public static VagaResponseDTO toDTO(Vaga vaga) {
        return new VagaResponseDTO(
                vaga.getNumeroVaga(),
                vaga.getValorMensal(),
                vaga.getDataCadastro(),
                MoradorResumoMapper.toDTO(vaga.getProprietario()),
                Collections.emptyList()
        );
    }
}

