package online.store.controllers;

import online.store.errors.NotFoundException;
import online.store.model.DTO.ProductDTO;
import online.store.model.Product;
import online.store.model.enumeration.ProductStatus;
import online.store.model.enumeration.constants.DirectionEnum;
import online.store.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
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

    @GetMapping("/sort/products")
    public ResponseEntity<List<Product>> sortProduct(@RequestParam("direction") DirectionEnum direction, @RequestParam("field") String... fields) {
        List<Product> products = this.productService.sortProducts(direction, fields);
        return ResponseEntity.ok(products);
    }

    @GetMapping("/pageable/products")
    public ResponseEntity<Page<Product>> getProductPageByPage(@RequestParam("page") final Integer page, @RequestParam(value = "count") final Integer count, @RequestParam(value = "direction", required = false) DirectionEnum direction, @RequestParam(value = "field", required = false) String... fields) {
        Page<Product> productPage = this.productService.readProductsPageByPage(page - 1, count, direction, fields);
        return ResponseEntity.ok(productPage);
    }


    @PutMapping("productstatus/{productId}")
    public ResponseEntity<Void> deleteProduct(@PathVariable("productId") final Long productId, final ProductStatus productStatus) throws NotFoundException {
        this.productService.deleteProduct(productId, productStatus);
        return ResponseEntity.ok().build();
    }
}
