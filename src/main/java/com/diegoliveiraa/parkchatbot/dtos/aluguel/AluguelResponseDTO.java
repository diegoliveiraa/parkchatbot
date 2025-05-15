package com.diegoliveiraa.parkchatbot.dtos.aluguel;

import com.diegoliveiraa.parkchatbot.dtos.morador.MoradorResumoDTO;
import com.diegoliveiraa.parkchatbot.dtos.morador.VagaMoradorResponseDTO;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record AluguelResponseDTO(
        VagaMoradorResponseDTO vaga,
        MoradorResumoDTO proprietario,
        MoradorResumoDTO inquilino,
        BigDecimal valorMensal,
        LocalDateTime inicio,
        LocalDateTime fim,
        String status
) {
}
