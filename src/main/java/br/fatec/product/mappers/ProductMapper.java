package br.fatec.product.mappers;

import br.fatec.product.dtos.ProductResponse;
import br.fatec.product.entities.Product;

public class ProductMapper {
    public static ProductResponse toDTO(Product product){
        return new ProductResponse(
                                    product.getId(),
                                    product.getName(),
                                    product.getPrice(),
                                    product.getCategory());
    }
}
