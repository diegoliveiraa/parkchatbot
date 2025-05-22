package com.diegoliveiraa.parkchatbot.dtos.vaga;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public record VagaRequestDTO(
        String numeroVaga,
        UUID proprietario) {
}
