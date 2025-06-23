package com.hexaware.hotpot.exceptions;

import org.springframework.http.HttpStatus;

public class BadRequestException extends RuntimeException {

    private HttpStatus status;
    private String message;

    public BadRequestException(HttpStatus status, String message) {
        super(message);           // ✅ Necessary to store the message in RuntimeException
        this.status = status;
        this.message = message;   // ✅ Explicitly store message if you want custom getter
    }

    public HttpStatus getStatus() {
        return status;
    }

    public String getMessage() {
        return message;           // You can also remove this if you only want super.getMessage()
    }
}
