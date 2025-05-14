package com.diegoliveiraa.parkchatbot.dtos.morador;

import com.diegoliveiraa.parkchatbot.entitys.Aluguel;

import java.util.List;

public record MoradorResponseDTO(
        String nome,
        String telefone,
        String residencia,
        VagaMoradorResponseDTO vaga,
        List<Aluguel> alugueisComoInquilino,
        List<Aluguel> alugueisComoProprietario) {

}
