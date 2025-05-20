package com.diegoliveiraa.parkchatbot.exceptions.aluguel;

import com.diegoliveiraa.parkchatbot.exceptions.BusinessException;

public class AluguelNotFoundException extends BusinessException {
    public AluguelNotFoundException() {
        super("Aluguel não encontrado");
    }
}
