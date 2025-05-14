package com.diegoliveiraa.parkchatbot.dtos.aluguel;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public record AluguelRequestDTO(UUID vagaId,
                                UUID proprietario,
                                UUID inquilinoId,
                                BigDecimal valorMensal,
                                LocalDateTime inicio,
                                LocalDateTime fim) {
}