package br.com.ygorfsguilherme.ui_blog.exception;

import org.springframework.http.HttpStatus;

public class InvalidCredentialsException extends BaseException {
    public InvalidCredentialsException() {
        super("Usuário inexistente ou senha inválida", HttpStatus.UNAUTHORIZED);
    }
}
