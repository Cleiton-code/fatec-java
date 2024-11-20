package br.fatec.product.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.fatec.product.dtos.ProductResponse;
import br.fatec.product.entities.Product;
import br.fatec.product.mappers.ProductMapper;
import br.fatec.product.repositories.ProductRepository;
import jakarta.persistence.EntityNotFoundException;

@Service

public class ProductService {

    @Autowired
    private ProductRepository repository;
    public List<ProductResponse>getAlProductsl(){
            return repository.findAll().stream()
            .map(p -> ProductMapper.toDTO(p))
            .collect(Collectors.toList());


    }
    public ProductResponse getProductByIProduct(long id){
        Product product = repository.findById(id).orElseThrow(
            () -> new EntityNotFoundException("Produto não cadastrado")
        );

        return ProductMapper.toDTO(product);
    }
    
    public void delete(long id){
        if(repository.existsById(id)){
            repository.deleteById(id);
        }
        else{
            throw new EntityNotFoundException("Produto não cadastrado");

        }
    }

    public ProductResponse save(Product product){
        Product newProduct = repository.save(product);
        return ProductMapper.toDTO(newProduct);
    }

    public void update(Product product, long id){
        Product aux = repository.getReferenceById(id);

        aux.setCategory(product.getCategory());
        aux.setName(product.getName());
        aux.setPrice(product.getPrice());

        repository.save(aux);
    }
}
