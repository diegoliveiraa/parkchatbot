package com.diegoliveiraa.parkchatbot.services;

import com.diegoliveiraa.parkchatbot.dtos.vaga.VagaRequestDTO;
import com.diegoliveiraa.parkchatbot.dtos.vaga.VagaResumoDTO;
import com.diegoliveiraa.parkchatbot.entitys.Morador;
import com.diegoliveiraa.parkchatbot.entitys.Vaga;
import com.diegoliveiraa.parkchatbot.exceptions.vaga.VagaNotFoundException;
import com.diegoliveiraa.parkchatbot.mappers.vaga.VagaMapper;
import com.diegoliveiraa.parkchatbot.repositories.VagaRepository;
import com.diegoliveiraa.parkchatbot.validators.MoradorValidator;
import com.diegoliveiraa.parkchatbot.validators.VagaValidator;
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
    private MoradorService moradorService;

    @Autowired
    private VagaValidator vagaValidator;

    @Autowired
    private MoradorValidator moradorValidator;

    public VagaResumoDTO createVaga(VagaRequestDTO dto) throws Exception {
        this.vagaValidator.validateCreate(dto);
        Vaga vaga = new Vaga(dto);
        vaga.setDataCadastro(LocalDateTime.now());

        if (dto.proprietario() != null) {
            Morador proprietario = this.moradorService.getEntidade(dto.proprietario());
            vaga.setProprietario(proprietario);
        }

        this.vagaRepository.save(vaga);

        return VagaMapper.toDTO(vaga);
    }

    public VagaResumoDTO getVaga(UUID uuid) throws Exception {
        this.vagaValidator.validateGet(uuid);
        Vaga vaga = this.getEntidade(uuid);
        return VagaMapper.toDTO(vaga);
    }

    public List<VagaResumoDTO> getAllVaga() {

        return this.vagaRepository.findAll().stream()
                .map(VagaMapper::toDTO
                )
                .collect(Collectors.toList());
    }

    public VagaResumoDTO updateVaga(UUID uuid, VagaRequestDTO dto) throws Exception {
        this.vagaValidator.validateUpdate(uuid, dto);
        Morador proprietario = this.moradorService.getEntidade(dto.proprietario());

        Vaga vaga = this.getEntidade(uuid);

        vaga.setNumeroVaga(dto.numeroVaga());
        vaga.setProprietario(proprietario);

        this.vagaRepository.save(vaga);

        return VagaMapper.toDTO(vaga);
    }

    public void deleteVaga(UUID uuid) throws Exception {
        this.vagaValidator.validateDelete(uuid);
        Vaga vaga = this.getEntidade(uuid);

        this.vagaRepository.delete(vaga);
    }

    public Vaga getEntidade(UUID uuid) throws Exception {
        return this.vagaRepository.findById(uuid).orElseThrow(VagaNotFoundException::new);
    }

    public void atribuirProprietario(UUID vagaId, UUID moradorId) throws Exception {

        Vaga vaga = this.getEntidade(vagaId);
        this.vagaValidator.validateAtribuirProprietario(vaga);
        Morador morador = this.moradorService.getEntidade(moradorId);
        this.moradorValidator.validateVaga(morador);

        vaga.setProprietario(morador);
        morador.setVaga(vaga);

        this.vagaRepository.save(vaga);
    }
}