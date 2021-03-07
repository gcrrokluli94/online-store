package online.store.services;

import online.store.errors.NotFoundException;
import online.store.model.Author;
import online.store.model.DTO.ProductDTO;
import online.store.model.Product;
import online.store.model.constants.ErrorMessages;
import online.store.model.enumeration.ProductType;
import online.store.model.ProductCategory;
import online.store.model.enumeration.ProductStatus;
import online.store.repositories.AuthorRepository;
import online.store.repositories.ProductCategoryRepository;
import online.store.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private ProductCategoryService productCategoryService;

    public List<Product> readAllProducts() {
        return productRepository.findAll();
    }

    public List<Product> findAvailableProduct() {
        return productRepository.findAvailableProduct();
    }


    public List<Product> findProductDifferentAttributes(final String productName,
                                                        final Double productPrice,
                                                        final ProductType productType,
                                                        final String productCategory) {
        return productRepository.findByProductNameAndPriceAndProductTypeAndProductCategoryName(productName, productPrice, productType, productCategory);

    }

    public Product saveProduct(final ProductDTO productDTO) {
        Product product = new Product();
        ProductCategory category = this.productCategoryRepository.findById(productDTO.getCategoryId())
                .orElseThrow(() -> new NotFoundException(ErrorMessages.ID_NOT_FOUND_EXCEPTION));

        Author author = this.authorRepository.findById(productDTO.getAuthorId())
                .orElseThrow(() -> new NotFoundException(ErrorMessages.ID_NOT_FOUND_EXCEPTION));
        product.setProductName(productDTO.getProductName());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        product.setProductStatus(productDTO.getProductStatus());
        product.setProductType(productDTO.getProductType());
        product.setAuthor(author);
        product.setProductCategory(category);
        return this.productRepository.save(product);
    }

    public Product updateProduct(final ProductDTO productDTO, final Long productId) {
        Product product = this.productRepository.findById(productId)
                .orElseThrow(() -> new NotFoundException(ErrorMessages.ID_NOT_FOUND_EXCEPTION));
        product.setProductName(productDTO.getProductName());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        product.setProductType(productDTO.getProductType());
        product.setProductStatus(productDTO.getProductStatus());
        return product;
    }

    public Product readProductById(final Long productId) {
        return this.productRepository.findById(productId)
                .orElseThrow(() -> new NotFoundException(ErrorMessages.ID_NOT_FOUND_EXCEPTION));
    }

    public void deleteProduct(final Long productId, final ProductStatus productStatus) {
        Product product = this.productRepository.findById(productId)
                .orElseThrow(() -> new NotFoundException(ErrorMessages.ID_NOT_FOUND_EXCEPTION));
        product.setProductStatus(productStatus.DELETED);
    }

}
