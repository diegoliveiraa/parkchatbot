package com.diegoliveiraa.parkchatbot.dtos.interesse;

import com.diegoliveiraa.parkchatbot.dtos.morador.MoradorResumoDTO;

import java.time.LocalDateTime;
import java.util.UUID;

public record InteresseResponseDTO(UUID id,
                                   UUID aluguelId,
                                   String numeroVaga,
                                   MoradorResumoDTO interessado,
                                   String status,
                                   LocalDateTime dataInteresse) {
}
