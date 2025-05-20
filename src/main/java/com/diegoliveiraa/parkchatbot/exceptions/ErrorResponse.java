package com.diegoliveiraa.parkchatbot.exceptions;

import org.apache.kafka.common.protocol.types.Field;

import java.time.LocalDateTime;

public record ErrorResponse(int status,
                            String message,
                            LocalDateTime timestamp) {
}
