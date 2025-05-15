package com.diegoliveiraa.parkchatbot.mappers.vaga;

import com.diegoliveiraa.parkchatbot.dtos.morador.VagaMoradorResponseDTO;
import com.diegoliveiraa.parkchatbot.entitys.Vaga;

public class VagaMoradorMapper {
    public static VagaMoradorResponseDTO toDo(Vaga vaga) {
        if (vaga == null) {
            return null;
        }
        return new VagaMoradorResponseDTO(vaga.getNumeroVaga());
    }
}
