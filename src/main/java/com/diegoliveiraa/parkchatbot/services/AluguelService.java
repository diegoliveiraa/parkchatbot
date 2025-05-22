package com.diegoliveiraa.parkchatbot.services;

import com.diegoliveiraa.parkchatbot.dtos.aluguel.requests.AluguelOfferRequestDTO;
import com.diegoliveiraa.parkchatbot.dtos.aluguel.requests.ConfirmAluguelRequestDTO;
import com.diegoliveiraa.parkchatbot.dtos.aluguel.responses.AluguelResponseDTO;
import com.diegoliveiraa.parkchatbot.dtos.aluguel.responses.ConfirmedAluguelResponseDTO;
import com.diegoliveiraa.parkchatbot.entitys.Aluguel;
import com.diegoliveiraa.parkchatbot.entitys.Interesse;
import com.diegoliveiraa.parkchatbot.entitys.Morador;
import com.diegoliveiraa.parkchatbot.entitys.Vaga;
import com.diegoliveiraa.parkchatbot.enums.AluguelStatus;
import com.diegoliveiraa.parkchatbot.enums.InteresseStatus;
import com.diegoliveiraa.parkchatbot.exceptions.aluguel.AluguelNotFoundException;
import com.diegoliveiraa.parkchatbot.mappers.aluguel.AluguelMapper;
import com.diegoliveiraa.parkchatbot.mappers.aluguel.ConfirmedAluguelMapper;
import com.diegoliveiraa.parkchatbot.repositories.AluguelRepository;
import com.diegoliveiraa.parkchatbot.validators.AluguelValidator;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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
    @Autowired
    private InteresseService interesseService;
    @Autowired
    private AluguelValidator aluguelValidator;

    public AluguelResponseDTO createOfferAluguel(AluguelOfferRequestDTO dto) throws Exception {
        this.aluguelValidator.validateCreateOffer(dto);
        Vaga vaga = this.vagaService.getEntidade(dto.vagaId());
        Morador proprietario = vaga.getProprietario();

        Aluguel offerAluguel = new Aluguel(dto);
        offerAluguel.setVaga(vaga);
        offerAluguel.setProprietario(proprietario);
        offerAluguel.setStatus(AluguelStatus.DISPONIVEL);

        this.save(offerAluguel);

        return AluguelMapper.toDTO(offerAluguel);
    }

    public ConfirmedAluguelResponseDTO confirmAluguel(ConfirmAluguelRequestDTO dto) throws Exception {

        this.aluguelValidator.validateConfirmAluguel(dto);

        Interesse interesse = this.interesseService.getEntidade(dto.interesseId());
        this.aluguelValidator.validateinteresseStatus(interesse.getStatus());

        Aluguel aluguel = interesse.getAluguel();
        this.aluguelValidator.validateAluguelStatus(aluguel.getStatus());

        aluguel.setInquilino(interesse.getInteressado());
        aluguel.setInicio(dto.inicio());
        aluguel.setFim(dto.fim());
        aluguel.setStatus(AluguelStatus.ATIVO);

        interesse.setStatus(InteresseStatus.APROVADO);

        this.interesseService.save(interesse);
        this.aluguelRepository.save(aluguel);
        this.interesseService.cancelOtherInteresse(interesse);

        return ConfirmedAluguelMapper.toDTO(aluguel);
    }

    public List<AluguelResponseDTO> getAluguelDisponivel() {
        return this.aluguelRepository.findByStatus(AluguelStatus.DISPONIVEL).stream()
                .map(AluguelMapper::toDTO)
                .collect(Collectors.toList());
    }

    public AluguelResponseDTO getAluguel(UUID uuid) {
        Aluguel aluguel = this.aluguelRepository.findById(uuid).orElseThrow(AluguelNotFoundException::new);
        return AluguelMapper.toDTO(aluguel);
    }

    public List<AluguelResponseDTO> getAllAluguel() {
        return this.aluguelRepository.findAll().stream()
                .map(AluguelMapper::toDTO
                )
                .collect(Collectors.toList());
    }

    public Aluguel getEntidade(UUID uuid) {
        return this.aluguelRepository.findById(uuid).orElseThrow(AluguelNotFoundException::new);
    }

    public AluguelResponseDTO cancelAluguel(UUID uuid) {
        Aluguel aluguel = this.getEntidade(uuid);
        this.aluguelValidator.validateCancel(aluguel.getStatus());

        aluguel.setStatus(AluguelStatus.ENCERRADO);
        this.save(aluguel);

        return AluguelMapper.toDTO(aluguel);
    }
    //Acionado via Scheduled
    public void endAlugueisFinalizados(){
        List<Aluguel> alugueis = this.aluguelRepository.findByStatusAndFimBefore(AluguelStatus.ATIVO, LocalDateTime.now());
        alugueis.forEach(aluguel -> {
            aluguel.setStatus(AluguelStatus.ENCERRADO);
            this.save(aluguel);
        });
    }

    public void save(Aluguel aluguel) {
        this.aluguelRepository.save(aluguel);
    }
}
