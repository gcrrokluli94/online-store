package online.store.controllers;

import online.store.errors.NotFoundException;
import online.store.model.DTO.ProductCategoryDTO;
import online.store.model.ProductCategory;
import online.store.services.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/api")
public class ProductCategoryController {

    @Autowired
    private ProductCategoryService productCategoryService;

    @PostMapping("/category")
    public ResponseEntity<ProductCategory> postProductCategory(@RequestBody @Valid final ProductCategoryDTO productCategoryDTO) throws NotFoundException {
        ProductCategory productCategory = this.productCategoryService.saveProductCategory(productCategoryDTO);
        return ResponseEntity.ok(productCategory);
    }
}
