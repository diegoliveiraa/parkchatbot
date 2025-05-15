package com.diegoliveiraa.parkchatbot.mappers;

import com.diegoliveiraa.parkchatbot.dtos.aluguel.AluguelResponseDTO;
import com.diegoliveiraa.parkchatbot.entitys.Aluguel;

public class AluguelMapper {
    public static AluguelResponseDTO toDTO(Aluguel aluguel) {
        if (aluguel == null) {
            return null;
        }
        return new AluguelResponseDTO(
                VagaMoradorMapper.toDo(aluguel.getVaga()),
                MoradorResumoMapper.toDTO(aluguel.getProprietario()),
                MoradorResumoMapper.toDTO(aluguel.getInquilino()),
                aluguel.getValorMensal(),
                aluguel.getInicio(),
                aluguel.getFim(),
                aluguel.getStatus().toString()
        );
    }
}
