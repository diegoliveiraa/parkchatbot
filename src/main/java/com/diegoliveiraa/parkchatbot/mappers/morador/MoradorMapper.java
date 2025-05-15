package com.diegoliveiraa.parkchatbot.mappers.morador;

import com.diegoliveiraa.parkchatbot.dtos.morador.MoradorResponseDTO;
import com.diegoliveiraa.parkchatbot.entitys.Morador;
import com.diegoliveiraa.parkchatbot.mappers.vaga.VagaMoradorMapper;

import java.util.Collections;

public class MoradorMapper {
    public static MoradorResponseDTO toDTO(Morador morador) {
        if (morador == null) {
            return null;
        }
        return new MoradorResponseDTO(
                morador.getNome(),
                morador.getTelefone(),
                morador.getResidencia(),
                VagaMoradorMapper.toDo(morador.getVaga()),
                Collections.emptyList(),
                Collections.emptyList()
        );
    }
}

