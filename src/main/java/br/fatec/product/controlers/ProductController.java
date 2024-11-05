package br.fatec.product.controlers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.fatec.product.entities.Product;
import br.fatec.product.service.ProductService;

@RestController
@RequestMapping("products")
public class ProductController {
    @Autowired
    private ProductService service;
    @GetMapping
    public List<Product> geProducts(){
            return service.getAlProductsl();
        
    }
    @GetMapping("(id)")
    public Product geProduct(@PathVariable long id){
            return service.getProductByIProduct(id);

    }
    
}
