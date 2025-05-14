package com.diegoliveiraa.parkchatbot.dtos.vaga;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public record VagaRequestDTO(
        UUID id,
        String numeroVaga,
        LocalDateTime dataCadastro,
        UUID proprietario,
        List<UUID> historicoAlugueis) {
}
