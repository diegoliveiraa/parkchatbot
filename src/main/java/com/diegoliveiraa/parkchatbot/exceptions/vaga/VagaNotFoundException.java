package com.diegoliveiraa.parkchatbot.exceptions.vaga;

import com.diegoliveiraa.parkchatbot.exceptions.BusinessException;

public class VagaNotFoundException extends BusinessException {
    public VagaNotFoundException( ) {
        super("Vaga não encontrada");
    }
}
