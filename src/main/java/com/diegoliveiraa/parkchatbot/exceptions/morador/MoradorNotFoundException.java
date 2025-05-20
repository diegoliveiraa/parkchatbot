package com.diegoliveiraa.parkchatbot.exceptions.morador;

import com.diegoliveiraa.parkchatbot.exceptions.BusinessException;

public class MoradorNotFoundException extends BusinessException {
    public MoradorNotFoundException() {
        super("Morador não encontrado");
    }
}
