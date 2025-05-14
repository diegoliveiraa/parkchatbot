package com.diegoliveiraa.parkchatbot.services;

import com.diegoliveiraa.parkchatbot.dtos.aluguel.AluguelOfferRequestDTO;
import com.diegoliveiraa.parkchatbot.dtos.aluguel.AluguelResponseDTO;
import com.diegoliveiraa.parkchatbot.dtos.aluguel.ConfirmAluguelRequestDTO;
import com.diegoliveiraa.parkchatbot.dtos.aluguel.ConfirmedAluguelResponseDTO;
import com.diegoliveiraa.parkchatbot.dtos.interesse.InteresseRequestDTO;
import com.diegoliveiraa.parkchatbot.dtos.interesse.InteresseResponseDTO;
import com.diegoliveiraa.parkchatbot.entitys.Aluguel;
import com.diegoliveiraa.parkchatbot.entitys.Interesse;
import com.diegoliveiraa.parkchatbot.entitys.Morador;
import com.diegoliveiraa.parkchatbot.entitys.Vaga;
import com.diegoliveiraa.parkchatbot.mappers.AluguelMapper;
import com.diegoliveiraa.parkchatbot.mappers.ConfirmedAluguelMapper;
import com.diegoliveiraa.parkchatbot.mappers.InteressadoMapper;
import com.diegoliveiraa.parkchatbot.repositories.AluguelRepository;
import com.diegoliveiraa.parkchatbot.repositories.InteresseRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
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
    @Autowired
    private InteresseService interesseService;

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

    public ConfirmedAluguelResponseDTO confirmAluguel(ConfirmAluguelRequestDTO dto) throws Exception {
        Interesse interesse = this.interesseService.getEntidade(dto.interesseId());

        Aluguel aluguel = interesse.getAluguel();

        if (aluguel.isAtivo()) {
            throw new IllegalStateException("Esta oferta ja foi confirmada");
        }

        aluguel.setInquilino(interesse.getInteressado());
        aluguel.setInicio(dto.inicio());
        aluguel.setFim(dto.fim());
        aluguel.setAtivo(true);

        this.aluguelRepository.save(aluguel);

        return ConfirmedAluguelMapper.toDTO(aluguel);
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
