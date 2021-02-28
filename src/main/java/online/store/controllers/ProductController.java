package online.store.controllers;

import online.store.model.Product;
import online.store.model.constants.DirectionEnum;
import online.store.model.enumeration.ProductType;
import online.store.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getProduct(){
        return ResponseEntity.ok().body(productService.readAllProduct());
    }

    @PostMapping("/user")
    public ResponseEntity<Product> saveProduct() {
        return ResponseEntity.ok().body(new Product());
    }

    @GetMapping("/in_stock_products")
    public ResponseEntity<List<Product>> getInStockProduct(){
        return ResponseEntity.ok().body(productService.readAllProduct());
    }

    @GetMapping("/filter-products")
    public ResponseEntity<List<Product>> getProductSearchByPage(@RequestParam("productName") final String productName,
                                                               @RequestParam("productPrice") final Double productPrice,
                                                               @RequestParam("productType") final ProductType productType,
                                                               @RequestParam("productCategory") final String productCategory){
        return ResponseEntity.ok().body(productService.findProductDifferentAttributes(productName, productPrice,productType,productCategory));
    }


}
