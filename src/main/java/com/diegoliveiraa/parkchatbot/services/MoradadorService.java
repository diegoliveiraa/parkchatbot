package com.diegoliveiraa.parkchatbot.services;

import com.diegoliveiraa.parkchatbot.dtos.morador.MoradorRequestDTO;
import com.diegoliveiraa.parkchatbot.dtos.morador.MoradorResponseDTO;
import com.diegoliveiraa.parkchatbot.entitys.Morador;
import com.diegoliveiraa.parkchatbot.exceptions.morador.MoradorNotFoundException;
import com.diegoliveiraa.parkchatbot.mappers.morador.MoradorMapper;
import com.diegoliveiraa.parkchatbot.repositories.MoradorRepository;
import com.diegoliveiraa.parkchatbot.validators.MoradorValidator;
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
    private MoradorValidator moradorValidator;

    public MoradorResponseDTO createMorador(MoradorRequestDTO dto) {
        this.moradorValidator.validateCreate(dto);
        Morador newMorador = new Morador(dto);
        this.moradorRepository.save(newMorador);
        return MoradorMapper.toDTO(newMorador);
    }

    public MoradorResponseDTO updateMorador(MoradorRequestDTO dto) {
        this.moradorValidator.validateUpdate(dto);
        Morador morador = this.moradorRepository.findById(dto.id())
                .orElseThrow(MoradorNotFoundException::new);
        morador.setNome(dto.nome());
        morador.setTelefone(dto.telefone());
        morador.setResidencia(dto.residencia());
        this.moradorRepository.save(morador);
        return MoradorMapper.toDTO(morador);
    }

    public void deleteMorador(UUID uuid) {
        this.moradorValidator.validateDelete(uuid);
        Morador morador = this.moradorRepository.findById(uuid)
                .orElseThrow(MoradorNotFoundException::new);
        this.moradorRepository.delete(morador);
    }

    public List<MoradorResponseDTO> getAllMorador() {
        return this.moradorRepository.findAll().stream()
                .map(MoradorMapper::toDTO
                )
                .collect(Collectors.toList());
    }

    public MoradorResponseDTO getMorador(UUID uuid) throws Exception {
        this.moradorValidator.validateGet(uuid);
        Morador morador = this.moradorRepository.findById(uuid).orElseThrow(MoradorNotFoundException::new);
        return MoradorMapper.toDTO(morador);
    }

    public Morador getEntidade(UUID uuid) throws Exception {
        this.moradorValidator.validateGet(uuid);
        return this.moradorRepository.findById(uuid).orElseThrow(MoradorNotFoundException::new);
    }
}
