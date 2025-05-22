package com.diegoliveiraa.parkchatbot.exceptions.interesse;

import com.diegoliveiraa.parkchatbot.exceptions.BusinessException;

public class InteresseAlreadyCancelledException extends BusinessException {
    public InteresseAlreadyCancelledException(String message) {
        super(message);
    }
}
