package com.yuriclaro.projetomongospring.resource.exception;

import java.io.Serializable;

public record StandardError(
    Long timestamp, 
    Integer status, 
    String error, 
    String path) implements Serializable {
} 