package br.com.ygorfsguilherme.ui_blog.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

public class ResponseException {
    private String message;
    private String error;
    private HttpStatus status;
    private LocalDateTime timestamp = LocalDateTime.now();

    public ResponseException(String message, HttpStatus status, String error) {
        this.message = message;
        this.status = status;
        this.error = error;
    }

    public ResponseException(String message, HttpStatus status) {
        this.message = message;
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public int getStatus() {
        return status.value();
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getError() {
        return error;
    }
}
