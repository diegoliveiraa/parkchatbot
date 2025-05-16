package com.diegoliveiraa.parkchatbot.mappers.aluguel;

import com.diegoliveiraa.parkchatbot.dtos.aluguel.responses.ConfirmedAluguelResponseDTO;
import com.diegoliveiraa.parkchatbot.entitys.Aluguel;

public class ConfirmedAluguelMapper {
    public static ConfirmedAluguelResponseDTO toDTO(Aluguel aluguel) {
        if (aluguel == null) {
            return null;
        }
        return new ConfirmedAluguelResponseDTO(
                aluguel.getId(),
                aluguel.getVaga().getNumeroVaga(),
                aluguel.getProprietario().getNome(),
                aluguel.getInquilino().getNome(),
                aluguel.getValorMensal(),
                aluguel.getInicio(),
                aluguel.getFim(),
                aluguel.getStatus().toString()
        );
    }
}
