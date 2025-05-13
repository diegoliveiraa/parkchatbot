package com.diegoliveiraa.parkchatbot.dtos;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public record VagaRequestDTO(
        String numeroVaga,
        BigDecimal valorMensal,
        boolean disponibilidade,
        LocalDateTime dataCadastro,
        UUID proprietario,
        UUID locatario,
        LocalDateTime dataAluguel) {
}
