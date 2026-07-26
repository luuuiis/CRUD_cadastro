package com.luuuiis.teste_projeto1.handler;

import java.util.InputMismatchException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.luuuiis.teste_projeto1.model.error.ErrorMessage;
import com.luuuiis.teste_projeto1.model.exception.ResourceNotFoundException;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    public ErrorMessage handleResourceNotFoundException(ResourceNotFoundException ex) {
        return new ErrorMessage("Recurso nao encontrado", HttpStatus.NOT_FOUND.value(), ex.getMessage());
    }

    @ExceptionHandler(InputMismatchException.class)
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    public ErrorMessage handleInputMismatchException(InputMismatchException ex) {
        return new ErrorMessage("Recurso nao encontrado", HttpStatus.NOT_FOUND.value(), ex.getMessage());
    }

}
