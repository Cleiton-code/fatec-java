package br.fatec.product.controlers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    public ResponseEntity<List<Product>> geProducts(){
            return ResponseEntity.ok(service.getAlProductsl());
        
    }
    @GetMapping("{id}")
    public ResponseEntity<Product> getProduct(@PathVariable long id){
            return ResponseEntity.ok(service.getProductByIProduct(id));

    }
    
    @DeleteMapping("{id}")
    public ResponseEntity<Void>deleteProduct(@PathVariable long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
        
    }

    @PutMapping()
    public ResponseEntity<Void> updateProduct(@PathVariable long id, @RequestBody Product product){
        service.update(product, id);
        return ResponseEntity.ok().build();
    }

    @PostMapping()
    public ResponseEntity<Product> saveProduct(@RequestBody Product product){
        Product newProduct = service.save(product);
        return ResponseEntity.created(null).body(newProduct);
    }
}
