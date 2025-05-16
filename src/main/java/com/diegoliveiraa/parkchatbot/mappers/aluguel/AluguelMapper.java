package com.diegoliveiraa.parkchatbot.mappers.aluguel;

import com.diegoliveiraa.parkchatbot.dtos.aluguel.responses.AluguelResponseDTO;
import com.diegoliveiraa.parkchatbot.entitys.Aluguel;
import com.diegoliveiraa.parkchatbot.mappers.morador.MoradorResumoMapper;
import com.diegoliveiraa.parkchatbot.mappers.vaga.VagaMoradorMapper;

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
