package com.diegoliveiraa.parkchatbot.dtos.aluguel.responses;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public record ConfirmedAluguelResponseDTO(
        UUID aluguelId,
        String numeroVaga,
        String nomeProprietario,
        String nomeInquilino,
        BigDecimal valorMensal,
        LocalDateTime inicio,
        LocalDateTime fim,
        String status
) {
}
