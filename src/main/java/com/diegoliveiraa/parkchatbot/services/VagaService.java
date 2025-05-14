package com.diegoliveiraa.parkchatbot.services;

import com.diegoliveiraa.parkchatbot.dtos.vaga.VagaRequestDTO;
import com.diegoliveiraa.parkchatbot.dtos.vaga.VagaResumoDTO;
import com.diegoliveiraa.parkchatbot.entitys.Morador;
import com.diegoliveiraa.parkchatbot.entitys.Vaga;
import com.diegoliveiraa.parkchatbot.mappers.VagaMapper;
import com.diegoliveiraa.parkchatbot.repositories.VagaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class VagaService {

    @Autowired
    private VagaRepository vagaRepository;

    @Autowired
    private MoradadorService moradadorService;

    public VagaResumoDTO createVaga(VagaRequestDTO dto) throws Exception {

        Vaga vaga = new Vaga(dto);
        vaga.setDataCadastro(LocalDateTime.now());

        if (dto.proprietario() != null) {
            Morador proprietario = this.moradadorService.getEntidade(dto.proprietario());
            vaga.setProprietario(proprietario);
        }

        this.vagaRepository.save(vaga);

        return VagaMapper.toDTO(vaga);
    }

    public VagaResumoDTO getVaga(UUID uuid) {

        Vaga vaga = this.vagaRepository.findById(uuid).orElseThrow(() -> new RuntimeException("Vaga não encontrada"));
        return VagaMapper.toDTO(vaga);
    }

    public List<VagaResumoDTO> getAllVaga() {

        return this.vagaRepository.findAll().stream()
                .map(VagaMapper::toDTO
                )
                .collect(Collectors.toList());
    }

    public VagaResumoDTO updateVaga(VagaRequestDTO dto) throws Exception {

        Morador proprietario = this.moradadorService.getEntidade(dto.proprietario());

        Vaga vaga = this.vagaRepository.findById(dto.id()).orElseThrow(() -> new RuntimeException("Vaga não encontrada"));

        vaga.setNumeroVaga(dto.numeroVaga());
        vaga.setProprietario(proprietario);

        this.vagaRepository.save(vaga);

        return VagaMapper.toDTO(vaga);
    }

    public void deleteVaga(UUID uuid) {

        Vaga vaga = this.vagaRepository.findById(uuid)
                .orElseThrow(() -> new EntityNotFoundException("Vaga não encontrado com id: " + uuid));

        this.vagaRepository.delete(vaga);
    }

    public Vaga getEntidade(UUID uuid) throws Exception {
        return this.vagaRepository.findById(uuid).orElseThrow(() -> new EntityNotFoundException("Vaga nao encontrado"));
    }

    public void atribuirProprietario(UUID vagaId, UUID moradorId) throws Exception {
        Vaga vaga = this.getEntidade(vagaId);
        Morador morador = this.moradadorService.getEntidade(moradorId);

        if (vaga.getProprietario() != null) {
            throw new IllegalStateException("Esta vaga ja possui um proprietario");
        }

        vaga.setProprietario(morador);
        morador.setVaga(vaga);

        this.vagaRepository.save(vaga);
    }
}