package com.diegoliveiraa.parkchatbot.dtos.vaga;

import com.diegoliveiraa.parkchatbot.dtos.aluguel.AluguelResponseDTO;
import com.diegoliveiraa.parkchatbot.dtos.morador.MoradorResumoDTO;

import java.util.List;

public record VagaResumoDTO(String numeroVaga,
                            MoradorResumoDTO proprietario,
                            List<AluguelResponseDTO> historicoAlugueis) {
}
