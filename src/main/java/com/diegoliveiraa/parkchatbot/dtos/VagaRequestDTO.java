package com.diegoliveiraa.parkchatbot.dtos;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public record VagaRequestDTO(
        UUID id,
        String numeroVaga,
        BigDecimal valorMensal,
        LocalDateTime dataCadastro,
        UUID proprietario,
        List<UUID> historicoAlugueis) {
}
