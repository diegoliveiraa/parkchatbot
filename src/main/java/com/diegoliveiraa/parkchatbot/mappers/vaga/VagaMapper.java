package com.diegoliveiraa.parkchatbot.mappers.vaga;

import com.diegoliveiraa.parkchatbot.dtos.vaga.VagaResumoDTO;
import com.diegoliveiraa.parkchatbot.entitys.Vaga;
import com.diegoliveiraa.parkchatbot.mappers.morador.MoradorResumoMapper;

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

