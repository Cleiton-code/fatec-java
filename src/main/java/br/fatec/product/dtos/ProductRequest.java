package br.fatec.product.dtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record ProductRequest(

    @NotBlank(message = "Nome não pode ser em branco")
    @Size(min = 3, message = "Tamanho mínimo para o nome são de 3 caracteres")
    String name, 

    @Min( value=0, message="Preço nao pode ser menor que zero")
    Double price,

    @NotBlank(message= "Categoria não pode ser em branco")
    String category
){

}

