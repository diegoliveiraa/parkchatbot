package com.diegoliveiraa.parkchatbot.mappers.aluguel;

import com.diegoliveiraa.parkchatbot.dtos.aluguel.responses.AluguelResumoVagaDTO;
import com.diegoliveiraa.parkchatbot.entitys.Aluguel;

public class AluguelresumoVagaMapper {
    public static AluguelResumoVagaDTO toDTO(Aluguel aluguel) {
        if (aluguel == null) {
            return null;
        }

        String inquilino = aluguel.getInquilino() != null
                ? aluguel.getInquilino().getNome()
                : null;
        return new AluguelResumoVagaDTO(
                aluguel.getId(),
                aluguel.getVaga().getNumeroVaga(),
                aluguel.getProprietario().getNome(),
                inquilino,
                aluguel.getStatus().toString()
        );
    }
}
