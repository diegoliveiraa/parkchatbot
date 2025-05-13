package com.diegoliveiraa.parkchatbot.mappers;

import com.diegoliveiraa.parkchatbot.dtos.VagaResponseDTO;
import com.diegoliveiraa.parkchatbot.entitys.Vaga;

import java.util.Collections;

public class VagaMapper {
    public static VagaResponseDTO toDTO(Vaga vaga) {
        if (vaga == null) {
            return null;
        }
        return new VagaResponseDTO(
                vaga.getNumeroVaga(),
                vaga.getValorMensal(),
                vaga.getDataCadastro(),
                null,
                Collections.emptyList()
        );
    }
}
