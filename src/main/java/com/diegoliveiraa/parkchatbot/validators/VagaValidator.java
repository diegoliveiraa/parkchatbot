package com.diegoliveiraa.parkchatbot.validators;

import com.diegoliveiraa.parkchatbot.dtos.vaga.VagaRequestDTO;
import com.diegoliveiraa.parkchatbot.entitys.Vaga;
import com.diegoliveiraa.parkchatbot.exceptions.vaga.InvalidVagaRequestException;
import com.diegoliveiraa.parkchatbot.exceptions.vaga.VagaAlreadyAssignedException;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class VagaValidator {
    public void validateCreate(VagaRequestDTO dto) {
        if (dto == null) {
            throw new InvalidVagaRequestException("Dados da requisição para criação do vaga não foram fornecidos.");
        }
        validateRequiredFields(dto);
    }

    public void validateUpdate(VagaRequestDTO dto) {
        if (dto.id() == null || !isValidUUID(dto.id().toString())) {
            throw new InvalidVagaRequestException("ID informado não é um UUID válido");
        }
        if (dto.proprietario() == null || dto.proprietario().toString().isBlank()) {
            throw new InvalidVagaRequestException("O proprietário não pode estar em branco");
        }
        validateRequiredFields(dto);
    }

    public void validateDelete(UUID uuid) {
        validateUUID(uuid);
    }

    public void validateGet(UUID uuid) {
        validateUUID(uuid);
    }

    public void validateAtribuirPropreitario(Vaga vaga){
        if (vaga.getProprietario() == null) {
            throw new VagaAlreadyAssignedException("Vaga já possui um proprietário");
        }
    }

    private void validateRequiredFields(VagaRequestDTO dto) {
        if (dto.numeroVaga() == null || dto.numeroVaga().isBlank()) {
            throw new InvalidVagaRequestException("Identificação do vaga é obrigatório");
        }
    }

    private void validateUUID(UUID uuid) {
        if (uuid == null || !isValidUUID(uuid.toString())) {
            throw new InvalidVagaRequestException("ID informado não é um UUID válido");
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
