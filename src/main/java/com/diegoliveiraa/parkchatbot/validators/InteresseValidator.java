package com.diegoliveiraa.parkchatbot.validators;

import com.diegoliveiraa.parkchatbot.entitys.Aluguel;
import com.diegoliveiraa.parkchatbot.entitys.Morador;
import com.diegoliveiraa.parkchatbot.enums.InteresseStatus;
import com.diegoliveiraa.parkchatbot.exceptions.interesse.InteresseAlreadyApprovedException;
import com.diegoliveiraa.parkchatbot.exceptions.interesse.InteresseAlreadyCancelledException;
import com.diegoliveiraa.parkchatbot.exceptions.interesse.InteresseAlreadyExistException;
import com.diegoliveiraa.parkchatbot.exceptions.interesse.InteresseInvalidOperationException;
import org.springframework.stereotype.Component;

@Component
public class InteresseValidator {
    public void validateCreate(Aluguel aluguel, Morador interessado, boolean isExist){
        if (isExist) {
            throw new InteresseAlreadyExistException("Este morador já demonstrou interesse por esta vaga.");
        }
        if (aluguel.getProprietario().getId().equals(interessado.getId())){
            throw new InteresseInvalidOperationException("O proprietário não pode manifestar interesse na própria vaga.");
        }
    }
    public void validateCancel(InteresseStatus status){
        if (status == InteresseStatus.APROVADO) {
            throw new InteresseAlreadyApprovedException("Não é possível cancelar um interesse já aprovado.");
        }
        if (status == InteresseStatus.CANCELADO) {
            throw new InteresseAlreadyCancelledException("Este interesse já está cancelado.");
        }
    }
}