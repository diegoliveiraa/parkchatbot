package com.diegoliveiraa.parkchatbot.dtos;

import com.diegoliveiraa.parkchatbot.entitys.Aluguel;
import com.diegoliveiraa.parkchatbot.entitys.Vaga;

import java.util.List;
import java.util.UUID;

public record MoradorResponseDTO(
        String nome,
        String telefone,
        String residencia,
        UUID vagaId,
        List<Aluguel> alugueisComoInquilino,
        List<Aluguel> alugueisComoProprietario) {

}
