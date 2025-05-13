package com.diegoliveiraa.parkchatbot.mappers;

import com.diegoliveiraa.parkchatbot.dtos.MoradorResponseDTO;
import com.diegoliveiraa.parkchatbot.entitys.Aluguel;
import com.diegoliveiraa.parkchatbot.entitys.Morador;

import java.util.Collections;
import java.util.stream.Collectors;

public class MoradorMapper {
    public static MoradorResponseDTO toDTO(Morador morador) {
        if (morador == null) {
            return null;
        }
        return new MoradorResponseDTO(
                morador.getNome(),
                morador.getTelefone(),
                morador.getResidencia(),
                morador.getVaga() != null ? morador.getVaga().getId() : null,
                Collections.emptyList(),
                Collections.emptyList()
        );
    }
}

