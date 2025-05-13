package com.diegoliveiraa.parkchatbot.dtos;

import com.diegoliveiraa.parkchatbot.entitys.Aluguel;
import com.diegoliveiraa.parkchatbot.entitys.Vaga;

import java.util.List;

public record MoradorResponseDTO(
        String nome,
        String telefone,
        String residencia,
        Vaga vaga,
        List<Aluguel> vagasAlugadas) {

}
