package com.diegoliveiraa.parkchatbot.services;

import com.diegoliveiraa.parkchatbot.dtos.interesse.InteresseRequestDTO;
import com.diegoliveiraa.parkchatbot.dtos.interesse.InteresseResponseDTO;
import com.diegoliveiraa.parkchatbot.entitys.Aluguel;
import com.diegoliveiraa.parkchatbot.entitys.Interesse;
import com.diegoliveiraa.parkchatbot.entitys.Morador;
import com.diegoliveiraa.parkchatbot.enums.InteresseStatus;
import com.diegoliveiraa.parkchatbot.exceptions.aluguel.AluguelNotFoundException;
import com.diegoliveiraa.parkchatbot.exceptions.interesse.InteresseAlreadyExistException;
import com.diegoliveiraa.parkchatbot.exceptions.interesse.InteresseNotFoundException;
import com.diegoliveiraa.parkchatbot.mappers.interesse.InteressadoMapper;
import com.diegoliveiraa.parkchatbot.repositories.AluguelRepository;
import com.diegoliveiraa.parkchatbot.repositories.InteresseRepository;
import com.diegoliveiraa.parkchatbot.validators.InteresseValidator;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class InteresseService {

    @Autowired
    private InteresseRepository interesseRepository;
    @Autowired
    private AluguelRepository aluguelRepository;
    @Autowired
    private MoradadorService moradadorService;
    @Autowired
    private InteresseValidator interesseValidator;

    public InteresseResponseDTO createInteresseAluguel(InteresseRequestDTO dto) throws Exception {
        Aluguel aluguel = this.aluguelRepository.findById(dto.aluguelId()).orElseThrow(AluguelNotFoundException::new);
        Morador interessado = this.moradadorService.getEntidade(dto.interessado());

        boolean isExist = this.interesseRepository.existByAluguelIdAndInteressadoId(dto.aluguelId(), dto.interessado());

        this.interesseValidator.validateCreate(aluguel, interessado, isExist);

        Interesse interesse = new Interesse();
        interesse.setAluguel(aluguel);
        interesse.setInteressado(interessado);
        interesse.setDataInteresse(LocalDateTime.now());
        interesse.setStatus(InteresseStatus.EM_ANALISE);

        this.save(interesse);

        return InteressadoMapper.toDTO(interesse);
    }

    public InteresseResponseDTO cancelInteresse(UUID uuid) {
        Interesse interesse = this.interesseRepository.findById(uuid).orElseThrow(InteresseNotFoundException::new);

        this.interesseValidator.validateCancel(interesse.getStatus());

        interesse.setStatus(InteresseStatus.CANCELADO);

        this.save(interesse);

        return InteressadoMapper.toDTO(interesse);
    }

    public Interesse getEntidade(UUID id) {
        return this.interesseRepository.findById(id).orElseThrow(InteresseNotFoundException::new);
    }

    public List<InteresseResponseDTO> getAllInteresse() {
        return this.interesseRepository.findAll().stream().map(InteressadoMapper::toDTO).collect(Collectors.toList());
    }

    public void save(Interesse interesse) {
        this.interesseRepository.save(interesse);
    }

    public void cancelOtherInteresse(Interesse aprovadoInteresse) {
        Aluguel aluguel = aprovadoInteresse.getAluguel();

        List<Interesse> interesses = this.interesseRepository.findByAluguelId(aluguel.getId());

        for (Interesse interesse : interesses) {
            if (!interesse.getId().equals(aprovadoInteresse.getId()) && interesse.getStatus() == InteresseStatus.EM_ANALISE) {
                interesse.setStatus(InteresseStatus.CANCELADO);
                this.save(interesse);
            }
        }
    }
}