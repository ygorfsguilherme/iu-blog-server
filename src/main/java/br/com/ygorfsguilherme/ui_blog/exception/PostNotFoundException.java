package br.com.ygorfsguilherme.ui_blog.exception;

import org.springframework.http.HttpStatus;

public class PostNotFoundException extends BaseException {
    private static String message = "Post não encontrado";

    public PostNotFoundException() {
        super(message, HttpStatus.NOT_FOUND);
    }

}
