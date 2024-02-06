package com.yuriclaro.projetomongospring.domain;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public record User(@Id String id, String name, String email) implements Serializable{

}