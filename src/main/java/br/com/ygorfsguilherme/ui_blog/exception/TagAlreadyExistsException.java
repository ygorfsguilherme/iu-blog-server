package br.com.ygorfsguilherme.ui_blog.exception;

import org.springframework.http.HttpStatus;

public class TagAlreadyExistsException extends BaseException {
    private static String message = "Tag já cadastrada";
    
    public TagAlreadyExistsException() {
        super(message, HttpStatus.CONFLICT);
    }
}