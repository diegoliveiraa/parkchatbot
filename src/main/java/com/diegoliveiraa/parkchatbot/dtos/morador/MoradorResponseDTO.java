package com.diegoliveiraa.parkchatbot.dtos.morador;

import com.diegoliveiraa.parkchatbot.dtos.aluguel.responses.AluguelResumoMoradorDTO;

import java.util.List;

public record MoradorResponseDTO(
        String nome,
        String telefone,
        String residencia,
        VagaMoradorResponseDTO vaga,
        List<AluguelResumoMoradorDTO> alugueisComoInquilino,
        List<AluguelResumoMoradorDTO> alugueisComoProprietario) {

}
