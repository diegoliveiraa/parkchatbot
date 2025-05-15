package com.diegoliveiraa.parkchatbot.mappers.aluguel;

import com.diegoliveiraa.parkchatbot.dtos.aluguel.AluguelResumoMoradorDTO;
import com.diegoliveiraa.parkchatbot.entitys.Aluguel;

public class AluguelResumoMoradorMapper {
    public static AluguelResumoMoradorDTO toDTO(Aluguel aluguel) {
        if (aluguel == null) {
            return null;
        }
        return new AluguelResumoMoradorDTO(
                aluguel.getId(),
                aluguel.getVaga().getNumeroVaga(),
                aluguel.getStatus().toString()
        );
    }
}
