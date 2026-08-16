package br.com.ygorfsguilherme.ui_blog.exception;

import org.springframework.http.HttpStatus;

public class UserAlreadyExistsException extends BaseException {
    public UserAlreadyExistsException() {
        super("Usuário já cadastrado", HttpStatus.CONFLICT);
    }
}
