package com.diegoliveiraa.parkchatbot.dtos.vaga;

import com.diegoliveiraa.parkchatbot.dtos.aluguel.AluguelResumoMoradorDTO;
import com.diegoliveiraa.parkchatbot.dtos.aluguel.AluguelResumoVagaDTO;
import com.diegoliveiraa.parkchatbot.dtos.morador.MoradorResumoDTO;

import java.util.List;

public record VagaResumoDTO(String numeroVaga,
                            MoradorResumoDTO proprietario,
                            List<AluguelResumoVagaDTO> historicoAlugueis) {
}
