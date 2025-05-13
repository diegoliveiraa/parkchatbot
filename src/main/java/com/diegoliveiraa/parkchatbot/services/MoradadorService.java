package com.diegoliveiraa.parkchatbot.services;

import com.diegoliveiraa.parkchatbot.dtos.MoradorRequestDTO;
import com.diegoliveiraa.parkchatbot.dtos.MoradorResponseDTO;
import com.diegoliveiraa.parkchatbot.entitys.Morador;
import com.diegoliveiraa.parkchatbot.mappers.MoradorMapper;
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

    public MoradorResponseDTO createMorador(MoradorRequestDTO dto) {

        Morador newMorador = new Morador(dto);

        this.moradorRepository.save(newMorador);

        return MoradorMapper.toDTO(newMorador);
    }

    public MoradorResponseDTO updateMorador(MoradorRequestDTO dto) {

        Morador morador = this.moradorRepository.findById(dto.id())
                .orElseThrow(() -> new EntityNotFoundException("Morador não encontrado com id: " + dto.id()));


        morador.setNome(dto.nome());
        morador.setTelefone(dto.telefone());
        morador.setResidencia(dto.residencia());

        this.moradorRepository.save(morador);

        return MoradorMapper.toDTO(morador);
    }

    public void deleteMorador(UUID uuid) {

        Morador morador = this.moradorRepository.findById(uuid)
                .orElseThrow(() -> new EntityNotFoundException("Morador não encontrado com id: " + uuid));

        this.moradorRepository.delete(morador);
    }

    public List<MoradorResponseDTO> getAllMorador() {

        return this.moradorRepository.findAll().stream()
                .map(MoradorMapper::toDTO
                )
                .collect(Collectors.toList());
    }

    public MoradorResponseDTO getMorador(UUID uuid) throws Exception {

        Morador morador = this.moradorRepository.findById(uuid).orElseThrow(() -> new Exception("Morador nao encontrado"));

        return MoradorMapper.toDTO(morador);
    }

    public Morador getEntidade(UUID uuid) throws Exception {
        return this.moradorRepository.findById(uuid).orElseThrow(() -> new Exception("Morador nao encontrado"));
    }
}
