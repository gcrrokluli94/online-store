package online.store.services;

import online.store.errors.NotFoundException;
import online.store.model.DTO.ProductCategoryDTO;
import online.store.model.ProductCategory;
import online.store.model.constants.ErrorMessages;
import online.store.repositories.ProductCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class ProductCategoryService {

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    public ProductCategory saveProductCategory(final ProductCategoryDTO productCategoryDTO){
        ProductCategory masterProduct = productCategoryRepository.findById(productCategoryDTO.getMasterCategoryId()).orElseThrow(()->
            new NotFoundException(ErrorMessages.ID_NOT_FOUND_EXCEPTION)
        );
        ProductCategory productCategory = new ProductCategory();
        productCategory.setName(productCategoryDTO.getName());
        productCategory.setDescription(productCategoryDTO.getDescription());
        productCategory.setMaster(masterProduct);
        return productCategoryRepository.save(productCategory);
    }
}
