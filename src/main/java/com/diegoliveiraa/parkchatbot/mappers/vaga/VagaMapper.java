package com.diegoliveiraa.parkchatbot.mappers.vaga;

import com.diegoliveiraa.parkchatbot.dtos.aluguel.responses.AluguelResumoVagaDTO;
import com.diegoliveiraa.parkchatbot.dtos.vaga.VagaResumoDTO;
import com.diegoliveiraa.parkchatbot.entitys.Vaga;
import com.diegoliveiraa.parkchatbot.mappers.aluguel.AluguelresumoVagaMapper;
import com.diegoliveiraa.parkchatbot.mappers.morador.MoradorResumoMapper;

import java.util.List;

public class VagaMapper {
    public static VagaResumoDTO toDTO(Vaga vaga) {
        if (vaga == null) {
            return null;
        }

        List<AluguelResumoVagaDTO> proprietarioList = vaga.getHistoricoAlugueis() != null
                ? vaga.getHistoricoAlugueis().stream()
                .map(AluguelresumoVagaMapper::toDTO)
                .toList()
                : List.of();
        return new VagaResumoDTO(
                vaga.getNumeroVaga(),
                MoradorResumoMapper.toDTO(vaga.getProprietario()),
                proprietarioList
        );
    }
}

