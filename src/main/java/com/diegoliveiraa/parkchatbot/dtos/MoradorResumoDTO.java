package com.diegoliveiraa.parkchatbot.dtos;

import java.util.UUID;

public record MoradorResumoDTO(
        UUID id,
        String nome,
        String telefone,
        String residencia
) {}