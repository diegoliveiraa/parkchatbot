package com.diegoliveiraa.parkchatbot.mappers.morador;

import com.diegoliveiraa.parkchatbot.dtos.aluguel.AluguelResumoMoradorDTO;
import com.diegoliveiraa.parkchatbot.dtos.morador.MoradorResponseDTO;
import com.diegoliveiraa.parkchatbot.entitys.Morador;
import com.diegoliveiraa.parkchatbot.mappers.aluguel.AluguelResumoMoradorMapper;
import com.diegoliveiraa.parkchatbot.mappers.vaga.VagaMoradorMapper;

import java.util.List;

public class MoradorMapper {
    public static MoradorResponseDTO toDTO(Morador morador) {
        if (morador == null) {
            return null;
        }
        List<AluguelResumoMoradorDTO> inquilinoList = morador.getAlugueisComoInquilino() != null
                ? morador.getAlugueisComoInquilino().stream()
                .map(AluguelResumoMoradorMapper::toDTO)
                .toList()
                : List.of();
        List<AluguelResumoMoradorDTO> proprietarioList = morador.getAlugueisComoProprietario() != null
                ? morador.getAlugueisComoProprietario().stream()
                .map(AluguelResumoMoradorMapper::toDTO)
                .toList()
                : List.of();
        return new MoradorResponseDTO(
                morador.getNome(),
                morador.getTelefone(),
                morador.getResidencia(),
                VagaMoradorMapper.toDo(morador.getVaga()),
                inquilinoList,
                proprietarioList
        );
    }
}

