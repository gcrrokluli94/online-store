package online.store.controllers;

import online.store.model.DTO.ProductDTO;
import online.store.model.Product;
import online.store.model.ProductCategory;
import online.store.model.constants.DirectionEnum;
import online.store.model.enumeration.ProductType;
import online.store.model.errors.NotFoundException;
import online.store.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.naming.ldap.HasControls;
import javax.validation.Valid;
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

    @GetMapping("/in_stock_products")
    public ResponseEntity<List<Product>> getInStockProduct(){
        return ResponseEntity.ok().body(productService.findAvaiableProduct());
    }

    @GetMapping("/filter-products")
    public ResponseEntity<List<Product>> getProductSearchByAttribut(@RequestParam("productName") final String productName,
                                                                    @RequestParam("productPrice") final Double productPrice,
                                                                    @RequestParam("productType") final ProductType productType,
                                                                    @RequestParam("productCategory") final String productCategory){
        return ResponseEntity.ok().body(productService.findProductDifferentAttributes(productName, productPrice,productType,productCategory));
    }

    @GetMapping("/filter-products-diferent-attributs")
    public ResponseEntity<List<Product>> getProductSearchBySelectingDifferentAttribut(@RequestParam("productName") final String productName,
                                                                    @RequestParam("productPrice") final Double productPrice,
                                                                    @RequestParam("productType") final ProductType productType,
                                                                    @RequestParam("productCategory") final String productCategory){
        return ResponseEntity.ok().body(productService.findProductForDifferentAttributes(productName, productPrice,productType,productCategory));
    }


    @GetMapping("/productName-search")
    public ResponseEntity<List<Product>> getProductSearchByName(@RequestParam("productName") final String productName){
        return ResponseEntity.ok().body(productService.findByProductName(productName));
    }

    @GetMapping("/productNameSearch")
    public ResponseEntity<List<Product>> getProductSearchByNameNativeQuery(@RequestParam("productName") final String productName){
        return ResponseEntity.ok().body(productService.findByProductNameNAtiveQuery(productName));
    }

//    @GetMapping("/product/page")
//    public ResponseEntity<Page<Product>> getProductSearchByPage(@RequestParam("page") final Integer page, @RequestParam(value = "count") final Integer count, @RequestParam(value = "direction",required = false) DirectionEnum direction, @RequestParam(value = "field",required = false) String  fields) {
//        Page<Product> userPage = this.productService.readProductPageByPage(page - 1, 2, DirectionEnum.ASC, fields);
//        return ResponseEntity.ok(userPage);
//    }
    @GetMapping("/product/page")
    public ResponseEntity<Page<Product>> getProductSearchByPage(@RequestParam("page") final Integer page, @RequestParam(value = "count") final Integer count, @RequestParam(value = "direction") DirectionEnum direction, @RequestParam(value = "field",required = false) String  fields) {
            Page<Product> userPage = this.productService.readProductPageByPage(page - 1, 3, DirectionEnum.ASC, fields);
            return ResponseEntity.ok(userPage);
}


    @PostMapping("/product")
    public ResponseEntity<Product> saveProduct(@RequestBody @Valid final ProductDTO productDTO) throws NotFoundException {
        Product product = this.productService.saveProduct(productDTO);
        return ResponseEntity.ok(product);
    }
}
