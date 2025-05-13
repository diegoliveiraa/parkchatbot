package com.diegoliveiraa.parkchatbot.dtos;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public record VagaResponseDTO(
        String numeroVaga,
        BigDecimal valorMensal,
        LocalDateTime dataCadastro,
        MoradorResumoDTO proprietario,
        List<AluguelResponseDTO> historicoAlugueis) {
}
