package com.yuriclaro.projetomongospring.service.exception;

public class ObjectNotFoundException extends RuntimeException {
    
    public ObjectNotFoundException(String message) {
        super(message);
    }
}
