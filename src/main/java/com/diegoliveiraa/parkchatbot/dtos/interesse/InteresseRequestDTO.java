package com.diegoliveiraa.parkchatbot.dtos.interesse;

import java.util.UUID;

public record InteresseRequestDTO(UUID aluguelId,
                                  UUID interessado) {
}