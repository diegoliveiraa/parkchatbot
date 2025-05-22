package com.diegoliveiraa.parkchatbot.exceptions.interesse;

import com.diegoliveiraa.parkchatbot.exceptions.BusinessException;

public class InteresseAlreadyApprovedException extends BusinessException {
    public InteresseAlreadyApprovedException(String message) {
        super(message);
    }
}
