package br.com.ygorfsguilherme.ui_blog.exception;

import org.springframework.http.HttpStatus;

public class BaseException extends RuntimeException {
    private String message;
    private HttpStatus status = HttpStatus.BAD_REQUEST;

    public BaseException(String message, HttpStatus status) {
        this.message = message;
        this.status = status;
    }

    public String getMessage() {
        return this.message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public ResponseException data() {
        return new ResponseException(this.getMessage(), this.getStatus());
    }
}

