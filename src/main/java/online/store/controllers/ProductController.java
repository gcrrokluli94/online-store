package online.store.controllers;

import online.store.entities.ProductEntity;
import online.store.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public ResponseEntity<List<ProductEntity>> getProduct(){
        return ResponseEntity.ok().body(productService.readAllProduct());
    }

    @PostMapping("/user")
    public ResponseEntity<ProductEntity> saveProduct() {
        return ResponseEntity.ok().body(new ProductEntity());
    }


}
