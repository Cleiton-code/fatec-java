package br.fatec.product.dtos;

public record ProductResponse (
    Long id,
    String name, 
    Double price,
    String category
){

}

