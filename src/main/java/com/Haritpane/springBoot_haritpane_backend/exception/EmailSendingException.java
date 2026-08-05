package com.Haritpane.springBoot_haritpane_backend.exception;

public class EmailSendingException extends RuntimeException{

    public EmailSendingException(String message) {
        super(message);
    }

    public EmailSendingException(String message, Throwable cause) {
        super(message, cause);
    }
}
