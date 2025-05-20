package com.diegoliveiraa.parkchatbot.exceptions.interesse;

import com.diegoliveiraa.parkchatbot.exceptions.BusinessException;

public class InteresseNotFoundException extends BusinessException {
    public InteresseNotFoundException() {
        super("Interesse não encontrado");
    }
}
