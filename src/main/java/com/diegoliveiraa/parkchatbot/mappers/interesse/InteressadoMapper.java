package com.diegoliveiraa.parkchatbot.mappers.interesse;

import com.diegoliveiraa.parkchatbot.dtos.interesse.InteresseResponseDTO;
import com.diegoliveiraa.parkchatbot.entitys.Interesse;
import com.diegoliveiraa.parkchatbot.mappers.morador.MoradorResumoMapper;

public class InteressadoMapper {
    public static InteresseResponseDTO toDTO(Interesse interesse){
        if (interesse == null) {
            return null;
        }
        return new InteresseResponseDTO(
                interesse.getId(),
                interesse.getAluguel().getId(),
                interesse.getAluguel().getVaga().getNumeroVaga(),
                MoradorResumoMapper.toDTO(interesse.getInteressado()),
                interesse.getStatus().toString(),
                interesse.getDataInteresse()
                );
    }
}
