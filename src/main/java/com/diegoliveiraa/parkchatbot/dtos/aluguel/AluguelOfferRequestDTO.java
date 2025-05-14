package com.diegoliveiraa.parkchatbot.dtos.aluguel;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public record AluguelOfferRequestDTO(UUID vagaId,
                                     BigDecimal valorMensal
                                     ) {
}