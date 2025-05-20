package com.diegoliveiraa.parkchatbot.dtos.morador;

import java.util.UUID;

public record MoradorRequestDTO(UUID id,
                                String nome,
                                String telefone,
                                String residencia
                                ) {
}