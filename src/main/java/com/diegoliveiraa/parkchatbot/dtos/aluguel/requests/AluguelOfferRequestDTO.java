package com.diegoliveiraa.parkchatbot.dtos.aluguel.requests;

import java.math.BigDecimal;
import java.util.UUID;

public record AluguelOfferRequestDTO(UUID vagaId,
                                     BigDecimal valorMensal
) {
}