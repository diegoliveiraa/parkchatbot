package com.diegoliveiraa.parkchatbot.services;

import com.diegoliveiraa.parkchatbot.dtos.MoradorRequestDTO;
import com.diegoliveiraa.parkchatbot.dtos.MoradorResponseDTO;
import com.diegoliveiraa.parkchatbot.entitys.Morador;
import com.diegoliveiraa.parkchatbot.repositories.MoradorRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class MoradadorService {
    @Autowired
    private MoradorRepository moradorRepository;
    @Autowired
    private VagaService vagaService;
    @Autowired
    private AluguelService aluguelService;

    public MoradorResponseDTO createMorador(MoradorRequestDTO dto) {

        Morador newMorador = new Morador(dto);

        this.moradorRepository.save(newMorador);

        return new MoradorResponseDTO(
                dto.nome(),
                dto.telefone(),
                dto.residencia(),
                null,
                List.of(),
                List.of());
    }

    public MoradorResponseDTO updateMorador(MoradorRequestDTO dto) {

        Morador morador = this.moradorRepository.findById(dto.id())
                .orElseThrow(() -> new EntityNotFoundException("Morador não encontrado com id: " + dto.id()));


        morador.setNome(dto.nome());
        morador.setTelefone(dto.telefone());
        morador.setResidencia(dto.residencia());

        this.moradorRepository.save(morador);

        return new MoradorResponseDTO(
                morador.getNome(),
                morador.getTelefone(),
                morador.getResidencia(),
                morador.getVaga(),
                morador.getAlugueisComoInquilino(),
                morador.getAlugueisComoProprietario());
    }

    public void deleteMorador(UUID uuid) {

        Morador morador = this.moradorRepository.findById(uuid)
                .orElseThrow(() -> new EntityNotFoundException("Morador não encontrado com id: " + uuid));

        this.moradorRepository.delete(morador);
    }

    public List<MoradorResponseDTO> getAllMorador() {

        return this.moradorRepository.findAll().stream()
                .map(morador -> new MoradorResponseDTO(
                        morador.getNome(),
                        morador.getTelefone(),
                        morador.getResidencia(),
                        morador.getVaga(),
                        morador.getAlugueisComoInquilino(),
                        morador.getAlugueisComoProprietario()
                ))
                .collect(Collectors.toList());
    }

    public MoradorResponseDTO getMorador(UUID uuid) throws Exception {

        Morador morador = this.moradorRepository.findById(uuid).orElseThrow(() -> new Exception("Morador nao encontrado"));

        return new MoradorResponseDTO(
                morador.getNome(),
                morador.getTelefone(),
                morador.getResidencia(),
                morador.getVaga(),
                morador.getAlugueisComoInquilino(),
                morador.getAlugueisComoProprietario());
    }

}
