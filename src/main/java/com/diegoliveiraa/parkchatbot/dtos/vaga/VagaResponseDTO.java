package com.diegoliveiraa.parkchatbot.dtos.vaga;

import com.diegoliveiraa.parkchatbot.dtos.aluguel.AluguelResponseDTO;
import com.diegoliveiraa.parkchatbot.dtos.morador.MoradorResumoDTO;

import java.time.LocalDateTime;
import java.util.List;

public record VagaResponseDTO(
        String numeroVaga,
        LocalDateTime dataCadastro,
        MoradorResumoDTO proprietario,
        List<AluguelResponseDTO> historicoAlugueis) {
}
