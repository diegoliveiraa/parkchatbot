package com.diegoliveiraa.parkchatbot.mappers;

import com.diegoliveiraa.parkchatbot.dtos.vaga.VagaResumoDTO;
import com.diegoliveiraa.parkchatbot.entitys.Vaga;

import java.util.Collections;

public class VagaMapper {
    public static VagaResumoDTO toDTO(Vaga vaga) {
        return new VagaResumoDTO(
                vaga.getNumeroVaga(),
                MoradorResumoMapper.toDTO(vaga.getProprietario()),
                Collections.emptyList()
        );
    }
}

