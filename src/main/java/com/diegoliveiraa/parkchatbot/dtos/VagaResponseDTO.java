package com.diegoliveiraa.parkchatbot.dtos;

import com.diegoliveiraa.parkchatbot.entitys.Morador;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record VagaResponseDTO(
        String numeroVaga,
        BigDecimal valorMensal,
        boolean disponibilidade,
        Morador proprietario,
        Morador locatario,
        LocalDateTime dataAluguel) {
}
