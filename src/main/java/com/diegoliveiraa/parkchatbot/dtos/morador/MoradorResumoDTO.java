package com.diegoliveiraa.parkchatbot.dtos.morador;

import java.util.UUID;

public record MoradorResumoDTO(
        UUID id,
        String nome,
        String telefone,
        String residencia
) {
}