package online.store.controllers;

import online.store.errors.NotFoundException;
import online.store.model.DTO.ProductDTO;
import online.store.model.Product;
import online.store.model.enumeration.ProductStatus;
import online.store.model.constants.DirectionEnum;
import online.store.model.enumeration.ProductType;
import online.store.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/product")
    public ResponseEntity<Product> postProduct(@RequestBody @Valid final ProductDTO productDTO) throws NotFoundException {
        Product product = this.productService.saveProduct(productDTO);
        return ResponseEntity.ok(product);
    }

    @PutMapping("/product/{productId}")
    public ResponseEntity<Product> putProduct(@RequestBody final ProductDTO productDTO, @PathVariable("productId") final Long productId) throws NotFoundException {
        Product product = this.productService.updateProduct(productDTO, productId);
        return ResponseEntity.ok(product);
    }

    @GetMapping("/product/{productId}")
    public ResponseEntity<Product> getProduct(@PathVariable("productId") final Long productId) throws NotFoundException {
        Product product = this.productService.readProductById(productId);
        return ResponseEntity.ok(product);
    }

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getProducts() {
        List<Product> products = this.productService.readAllProducts();
        return ResponseEntity.ok(products);
    }

    @PostMapping("/user")
    public ResponseEntity<Product> saveProduct() {
        return ResponseEntity.ok().body(new Product());
    }

    @PutMapping("productstatus/{productId}")
    public ResponseEntity<Void> deleteProduct(@PathVariable("productId") final Long productId, final ProductStatus productStatus) throws NotFoundException {
        this.productService.deleteProduct(productId, productStatus);
        return ResponseEntity.ok().build();
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
