package com.diegoliveiraa.parkchatbot.exceptions.aluguel;

public class AluguelAlreadyConfirmedException extends RuntimeException {
    public AluguelAlreadyConfirmedException(String message) {
        super(message);
    }
}
