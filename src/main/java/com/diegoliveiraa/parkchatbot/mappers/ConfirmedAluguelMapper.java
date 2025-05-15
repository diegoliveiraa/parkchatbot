package com.diegoliveiraa.parkchatbot.mappers;

import com.diegoliveiraa.parkchatbot.dtos.aluguel.ConfirmedAluguelResponseDTO;
import com.diegoliveiraa.parkchatbot.dtos.interesse.InteresseResponseDTO;
import com.diegoliveiraa.parkchatbot.entitys.Aluguel;
import com.diegoliveiraa.parkchatbot.entitys.Interesse;

public class ConfirmedAluguelMapper {
    public static ConfirmedAluguelResponseDTO toDTO(Aluguel aluguel){
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
