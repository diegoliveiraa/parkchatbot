package com.diegoliveiraa.parkchatbot.validators;

import com.diegoliveiraa.parkchatbot.dtos.aluguel.requests.AluguelOfferRequestDTO;
import com.diegoliveiraa.parkchatbot.dtos.aluguel.requests.ConfirmAluguelRequestDTO;
import com.diegoliveiraa.parkchatbot.enums.AluguelStatus;
import com.diegoliveiraa.parkchatbot.enums.InteresseStatus;
import com.diegoliveiraa.parkchatbot.exceptions.aluguel.AluguelAlreadyCancelledException;
import com.diegoliveiraa.parkchatbot.exceptions.aluguel.AluguelAlreadyConfirmedException;
import com.diegoliveiraa.parkchatbot.exceptions.aluguel.InvalidAluguelRequestException;
import com.diegoliveiraa.parkchatbot.exceptions.morador.InvalidMoradorRequestException;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Component
public class AluguelValidator {
    public void validateCreateOffer(AluguelOfferRequestDTO dto){
        validateUUID(dto.vagaId());
        if (dto.valorMensal() == null) {
            throw new InvalidAluguelRequestException("Informe um valor para o valor mensal");
        }
        if (dto.valorMensal().compareTo(BigDecimal.ZERO) < 0) {
            throw new InvalidAluguelRequestException("Informe um valor válido");
        }
    }
    public  void validateConfirmAluguel(ConfirmAluguelRequestDTO dto){

        LocalDate dataInicio = dto.inicio().toLocalDate();
        LocalDate dataFim = dto.fim().toLocalDate();
        LocalDate dataHoje = LocalDate.now();

        if (dataInicio.isBefore(dataHoje)) {
            throw new InvalidAluguelRequestException("Informe uma data de início válida");
        }
        if (dataFim.isBefore(dataInicio)) {
            throw new InvalidAluguelRequestException("O fim do contrato não pode ser antes que o início");
        }
    }
    public void validateAluguelStatus(AluguelStatus status){
        if (status != AluguelStatus.DISPONIVEL) {
            throw new AluguelAlreadyConfirmedException("Esta oferta já foi confirmada");
        }
    }
    public void validateinteresseStatus(InteresseStatus status){
        if (status == InteresseStatus.APROVADO) {
            throw new AluguelAlreadyConfirmedException("Este interesse já foi aprovado");
        }
    }
    public  void validateCancel(AluguelStatus status){
        if (status == AluguelStatus.ENCERRADO) {
            throw new AluguelAlreadyCancelledException("Não é possivel encerrar um aluguel já encerrado");
        }
    }

    private void validateUUID(UUID uuid) {
        if (uuid == null || !isValidUUID(uuid.toString())) {
            throw new InvalidMoradorRequestException("ID informado não é um UUID válido");
        }
    }

    private boolean isValidUUID(String id) {
        try {
            UUID.fromString(id);
            return true;
        } catch (IllegalArgumentException ex) {
            return false;
        }
    }
}
