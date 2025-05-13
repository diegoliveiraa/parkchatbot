package com.diegoliveiraa.parkchatbot.mappers;

import com.diegoliveiraa.parkchatbot.dtos.AluguelResponseDTO;
import com.diegoliveiraa.parkchatbot.entitys.Aluguel;

public class AluguelMapper {
    public static AluguelResponseDTO toDTO(Aluguel aluguel) {
        if (aluguel == null) {
            return null;
        }
        return new AluguelResponseDTO(
                aluguel.getVaga(),
                aluguel.getProprietario(),
                aluguel.getInquilino(),
                aluguel.getInicio(),
                aluguel.getFim(),
                aluguel.isAtivo()
        );
    }
}
