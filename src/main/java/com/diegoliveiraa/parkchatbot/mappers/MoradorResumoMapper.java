package com.diegoliveiraa.parkchatbot.mappers;

import com.diegoliveiraa.parkchatbot.dtos.morador.MoradorResumoDTO;
import com.diegoliveiraa.parkchatbot.entitys.Morador;

public class MoradorResumoMapper {
    public static MoradorResumoDTO toDTO(Morador morador) {
        if (morador == null) {
            return null;
        }

        return new MoradorResumoDTO(
                morador.getId(),
                morador.getNome(),
                morador.getTelefone(),
                morador.getResidencia()
        );
    }
}

