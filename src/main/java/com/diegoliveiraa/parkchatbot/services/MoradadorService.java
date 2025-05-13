package com.diegoliveiraa.parkchatbot.services;

import com.diegoliveiraa.parkchatbot.dtos.MoradorRequestDTO;
import com.diegoliveiraa.parkchatbot.dtos.MoradorResponseDTO;
import com.diegoliveiraa.parkchatbot.entitys.Morador;
import com.diegoliveiraa.parkchatbot.entitys.Vaga;
import com.diegoliveiraa.parkchatbot.repositories.MoradorRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class MoradadorService {
    @Autowired
    private MoradorRepository moradorRepository;
    @Autowired
    private VagaService vagaService;

    public MoradorResponseDTO createMorador(MoradorRequestDTO dto) {

        Vaga vagaPropria = this.vagaService.getVaga(dto.vaga());

        List<Vaga> vagasAlugadas = dto.vagasAlugadas() != null
                ? dto.vagasAlugadas().stream()
                .map(vagaService::getVaga)
                .collect(Collectors.toList())
                : new ArrayList<>();

        Morador newMorador = new Morador(dto);
        newMorador.setVaga(vagaPropria);
        newMorador.setVagasAlugadas(vagasAlugadas);

        this.moradorRepository.save(newMorador);

        MoradorResponseDTO responseDTO = new MoradorResponseDTO(
                dto.nome(),
                dto.telefone(),
                dto.residencia(),
                vagaPropria,
                vagasAlugadas);

        return responseDTO;
    }

    public MoradorResponseDTO updateMorador(MoradorRequestDTO dto) {

        Vaga vagaPropria = this.vagaService.getVaga(dto.vaga());

        List<Vaga> vagasAlugadas = dto.vagasAlugadas() != null
                ? dto.vagasAlugadas().stream()
                .map(vagaService::getVaga)
                .collect(Collectors.toList())
                : new ArrayList<>();

        Morador getMorador = this.moradorRepository.findById(dto.id())
                .orElseThrow(() -> new EntityNotFoundException("Morador não encontrado com id: " + dto.id()));


        getMorador.setNome(dto.nome());
        getMorador.setTelefone(dto.telefone());
        getMorador.setResidencia(dto.residencia());
        getMorador.setVaga(vagaPropria);
        getMorador.setVagasAlugadas(vagasAlugadas);

        this.moradorRepository.save(getMorador);

        return new MoradorResponseDTO(
                getMorador.getNome(),
                getMorador.getTelefone(),
                getMorador.getResidencia(),
                getMorador.getVaga(),
                getMorador.getVagasAlugadas());
    }

    public void deleteMorador(UUID uuid) {

        this.moradorRepository.deleteById(uuid);
    }

    public List<MoradorResponseDTO> getAllMorador() {

        List<Morador> moradores = this.moradorRepository.findAll();

        List<MoradorResponseDTO> listMoradores = new ArrayList<>();
        for (Morador morador : moradores) {
            listMoradores.add(new MoradorResponseDTO(
                    morador.getNome(),
                    morador.getTelefone(),
                    morador.getResidencia(),
                    morador.getVaga(),
                    morador.getVagasAlugadas()));
        }
        return listMoradores;
    }

    public MoradorResponseDTO getMorador(UUID uuid) throws Exception {

        Morador morador = this.moradorRepository.findById(uuid).orElseThrow(() -> new Exception("Morador nao encontrado"));

        MoradorResponseDTO responseDTO = new MoradorResponseDTO(
                morador.getNome(),
                morador.getTelefone(),
                morador.getResidencia(),
                morador.getVaga(),
                morador.getVagasAlugadas());

        return responseDTO;
    }

}
