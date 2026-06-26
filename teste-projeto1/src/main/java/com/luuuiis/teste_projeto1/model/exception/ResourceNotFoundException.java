package com.luuuiis.teste_projeto1.model.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND) // Retorna o status 404 quando essa exceção for lançada    
public class ResourceNotFoundException {
    
}
