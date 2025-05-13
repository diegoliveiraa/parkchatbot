package com.diegoliveiraa.parkchatbot.dtos;

import java.util.List;
import java.util.UUID;

public record MoradorRequestDTO(UUID id,
                                String nome,
                                String telefone,
                                String residencia,
                                UUID vaga,
                                List<UUID> alugueisComoInquilino,
                                List<UUID> alugueisComoProprietario) {
}