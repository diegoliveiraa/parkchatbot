package com.diegoliveiraa.parkchatbot.dtos.aluguel.requests;

import java.time.LocalDateTime;
import java.util.UUID;

public record ConfirmAluguelRequestDTO(UUID interesseId,
                                       LocalDateTime inicio,
                                       LocalDateTime fim) {
}
