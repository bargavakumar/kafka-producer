package com.prokarma.poc.publisher.exceptions;

public class PublisherException extends RuntimeException {
    private String message;

    public PublisherException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
