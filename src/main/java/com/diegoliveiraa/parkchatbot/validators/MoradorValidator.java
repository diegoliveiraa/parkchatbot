package com.diegoliveiraa.parkchatbot.validators;

import com.diegoliveiraa.parkchatbot.dtos.morador.MoradorRequestDTO;
import com.diegoliveiraa.parkchatbot.entitys.Morador;
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

    public void validateUpdate(UUID uuid, MoradorRequestDTO dto) {
        validateUUID(uuid);
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
        String telefone = dto.telefone().trim();
        if (telefone.length() != 11 || !telefone.matches("\\d{11}")) {
            throw new InvalidMoradorRequestException("Numero de telefone invalido");
        }
    }
    public void validateVaga(Morador morador) {
        if (morador.getVaga() != null) {
            throw new InvalidMoradorRequestException("Este morador já é proprietário de outra vaga.");
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

