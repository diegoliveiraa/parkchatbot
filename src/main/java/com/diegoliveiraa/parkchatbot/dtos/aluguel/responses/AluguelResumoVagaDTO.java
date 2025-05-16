package com.diegoliveiraa.parkchatbot.dtos.aluguel.responses;

import java.util.UUID;

public record AluguelResumoVagaDTO(UUID id,
                                   String numeroVaga,
                                   String proprietario,
                                   String inquilino,
                                   String status) {
}
