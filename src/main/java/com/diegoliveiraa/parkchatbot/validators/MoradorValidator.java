package com.diegoliveiraa.parkchatbot.validators;

import com.diegoliveiraa.parkchatbot.dtos.morador.MoradorRequestDTO;
import com.diegoliveiraa.parkchatbot.exceptions.morador.InvalidMoradorRequestException;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class MoradorValidator {

    public void validateCreate(MoradorRequestDTO dto) {
        if (dto == null) {
            throw new InvalidMoradorRequestException("Dados da requisição para criação do morador não foram fornecidos.");
        }
        validateRequiredFields(dto);
    }

    public void validateUpdate(MoradorRequestDTO dto) {
        if (dto.id() == null || !isValidUUID(dto.id().toString())) {
            throw new InvalidMoradorRequestException("ID informado não é um UUID válido");
        }
        validateRequiredFields(dto);
    }

    public void validateDelete(UUID uuid) {
        validateUUID(uuid);
    }

    public void validateGet(UUID uuid) {
        validateUUID(uuid);
    }

    private void validateRequiredFields(MoradorRequestDTO dto) {
        if (dto.nome() == null || dto.nome().isBlank()) {
            throw new InvalidMoradorRequestException("Nome do morador é obrigatório");
        }
        if (dto.residencia() == null || dto.residencia().isBlank()) {
            throw new InvalidMoradorRequestException("Residência do morador é obrigatória");
        }
        if (dto.telefone() == null || dto.telefone().isBlank()) {
            throw new InvalidMoradorRequestException("Telefone do morador é obrigatório");
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

