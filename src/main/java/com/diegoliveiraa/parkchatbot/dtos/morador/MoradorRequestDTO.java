package com.diegoliveiraa.parkchatbot.dtos.morador;

import java.util.UUID;

public record MoradorRequestDTO(String nome,
                                String telefone,
                                String residencia
                                ) {
}