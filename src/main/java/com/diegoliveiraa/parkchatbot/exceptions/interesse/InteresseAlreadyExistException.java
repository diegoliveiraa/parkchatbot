package com.diegoliveiraa.parkchatbot.exceptions.interesse;

import com.diegoliveiraa.parkchatbot.exceptions.BusinessException;

public class InteresseAlreadyExistException extends BusinessException {
    public InteresseAlreadyExistException(String message) {
        super(message);
    }
}
