package br.com.ygorfsguilherme.ui_blog.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BaseException.class)
    public ResponseEntity<ResponseException> handleBaseException(BaseException ex) {
        return new ResponseEntity<>(ex.data(), ex.getStatus());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseException> handleValidationException(MethodArgumentNotValidException ex) {
        
        String message = ex.getBindingResult().getFieldErrors().stream()
                            .map(FieldError::getDefaultMessage)
                            .findFirst()
                            .orElse("Erro desconhecido");
        
        ResponseException response = new ResponseException(
            message, 
            HttpStatus.BAD_REQUEST, 
            "Validation Error");

        return ResponseEntity.badRequest().body(response);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseException> handleGenericException(Exception ex) {
        ResponseException response = new ResponseException(
                ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR
        );
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }
}
