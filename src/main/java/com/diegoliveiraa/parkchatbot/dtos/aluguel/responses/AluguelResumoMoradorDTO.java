package com.diegoliveiraa.parkchatbot.dtos.aluguel.responses;

import java.util.UUID;

public record AluguelResumoMoradorDTO(UUID id,
                                      String numeroVaga,
                                      String status) {
}
