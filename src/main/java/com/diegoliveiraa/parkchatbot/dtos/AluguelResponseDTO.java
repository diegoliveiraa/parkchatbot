package com.diegoliveiraa.parkchatbot.dtos;

import com.diegoliveiraa.parkchatbot.entitys.Morador;
import com.diegoliveiraa.parkchatbot.entitys.Vaga;

import java.time.LocalDateTime;

public record AluguelResponseDTO(
        Vaga vaga,
        Morador proprietario,
        Morador inquilino,
        LocalDateTime inicio,
        LocalDateTime fim,
        boolean ativo) {
}
