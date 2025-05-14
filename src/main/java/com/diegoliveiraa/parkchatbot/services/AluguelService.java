package com.diegoliveiraa.parkchatbot.services;

import com.diegoliveiraa.parkchatbot.dtos.aluguel.AluguelOfferRequestDTO;
import com.diegoliveiraa.parkchatbot.dtos.aluguel.AluguelResponseDTO;
import com.diegoliveiraa.parkchatbot.dtos.aluguel.ConfirmAluguelRequestDTO;
import com.diegoliveiraa.parkchatbot.entitys.Aluguel;
import com.diegoliveiraa.parkchatbot.entitys.Morador;
import com.diegoliveiraa.parkchatbot.entitys.Vaga;
import com.diegoliveiraa.parkchatbot.mappers.AluguelMapper;
import com.diegoliveiraa.parkchatbot.repositories.AluguelRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class AluguelService {
    @Autowired
    private AluguelRepository aluguelRepository;
    @Autowired
    private VagaService vagaService;
    @Autowired
    private MoradadorService moradadorService;

    public AluguelResponseDTO createOfferAluguel(AluguelOfferRequestDTO dto) throws Exception {

        Vaga vaga = this.vagaService.getEntidade(dto.vagaId());
        Morador proprietario = vaga.getProprietario();

        Aluguel offerAluguel = new Aluguel(dto);
        offerAluguel.setVaga(vaga);
        offerAluguel.setProprietario(proprietario);
        offerAluguel.setAtivo(false);

        this.aluguelRepository.save(offerAluguel);

        return AluguelMapper.toDTO(offerAluguel);
    }

    public AluguelResponseDTO confirmAluguel(ConfirmAluguelRequestDTO dto) throws Exception {
        Aluguel aluguel = aluguelRepository.findById(dto.aluguelId()).orElseThrow(()->new EntityNotFoundException("Aluguel não encontrado"));
        if (aluguel.isAtivo()) {
            throw  new IllegalStateException("Esta vaga ja esta alugada");
        }

        Morador inquilino = this.moradadorService.getEntidade(dto.inquilinoId());

        aluguel.setInquilino(inquilino);
        aluguel.setInicio(dto.inicio());
        aluguel.setFim(dto.fim());
        aluguel.setAtivo(true);

        this.aluguelRepository.save(aluguel);

        return AluguelMapper.toDTO(aluguel);
    }

    public AluguelResponseDTO getAluguel(UUID uuid) {
        Aluguel aluguel = this.aluguelRepository.findById(uuid).orElseThrow(() -> new EntityNotFoundException("Aluguel não encontrada"));
        return AluguelMapper.toDTO(aluguel);
    }

    public List<AluguelResponseDTO> getAllAluguel() {
        return this.aluguelRepository.findAll().stream()
                .map(AluguelMapper::toDTO
                )
                .collect(Collectors.toList());
    }

    public Aluguel getEntidade(UUID uuid) {
        return this.aluguelRepository.findById(uuid).orElseThrow(() -> new EntityNotFoundException("Aluguel não encontrado"));
    }

}
