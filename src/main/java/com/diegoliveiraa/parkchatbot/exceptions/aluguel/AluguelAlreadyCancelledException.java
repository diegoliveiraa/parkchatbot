package com.diegoliveiraa.parkchatbot.exceptions.aluguel;

public class AluguelAlreadyCancelledException extends RuntimeException {
    public AluguelAlreadyCancelledException(String message) {
        super(message);
    }
}
