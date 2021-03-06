package online.store.services;

import online.store.model.Author;
import online.store.model.DTO.ProductDTO;
import online.store.model.Product;
import online.store.model.ProductCategory;
import online.store.model.constants.DirectionEnum;
import online.store.model.constants.ErrorMessages;
import online.store.model.enumeration.ProductType;

import online.store.model.errors.NotFoundException;
import online.store.repositories.AuthorRepository;
import online.store.repositories.ProductCategoryRepository;
import online.store.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ProductService   {

        @Autowired
        private ProductRepository productRepository;

        @Autowired
        private ProductCategoryRepository productCategoryRepository;

        @Autowired
        private AuthorRepository authorRepository;


        public List<Product> readAllProduct(){
           return productRepository.findAll();
        }

        public List<Product> findAvaiableProduct(){return productRepository.findAvaiableProduct();}


        public List<Product> findProductDifferentAttributes(final String productName,
                                                            final Double productPrice,
                                                            final ProductType productType,
                                                            final String productCategory) {
        return productRepository.findByProductNameAndPriceAndProductTypeAndProductCategoryName(productName, productPrice, productType, productCategory);
       }

        public List<Product> findProductForDifferentAttributes(final String productName,
                                                        final Double productPrice,
                                                        final ProductType productType,
                                                        final String productCategory) {
        return productRepository.findByProductNameOrPriceOrProductTypeOrProductCategoryName(productName, productPrice, productType, productCategory);
       }

       public List<Product> findByProductName( final String productName){
            return productRepository.findByProductName(productName);
       }

        public List<Product> findByProductNameNAtiveQuery( final String productName){
               return productRepository.findByProductNameNativeQuery(productName);
        }



//        public Page<Product> readProductPageByPage(final Integer page, final Integer count, final DirectionEnum direction, final String... fields) {
//                if (direction == null || fields == null)
//                        return this.productRepository.findAll(PageRequest.of(page, count));
//                return this.productRepository.findAll(PageRequest.of(page, count, Sort.Direction.valueOf(direction.name()), fields));
//
//        }
        public Page<Product> readProductPageByPage(final Integer page, final Integer count, final DirectionEnum direction, final String fields) {
                if (direction == null || fields == null)
                    return this.productRepository.findAll(PageRequest.of(page, count));
                return this.productRepository.findAll(PageRequest.of(page, count, Sort.Direction.valueOf(direction.name()), fields));

}

    public Product saveProduct(final ProductDTO productDTO) {
        Product product = new Product();

        //ProductCategory category = this.productCategoryRepository.findById(productDTO.getProductCategories())
         //       .orElseThrow(()-> new NotFoundException(ErrorMessages.ID_NOT_FOUND_EXCEPTION));
       //Author author = this.authorRepository.findById(productDTO.getAuthor())
        //        .orElseThrow(()-> new NotFoundException(ErrorMessages.ID_NOT_FOUND_EXCEPTION));

        product.setProductName(productDTO.getProductName());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());

        Set<ProductCategory> productCategory = this.productCategoryRepository.findById(productDTO.getProductCategory());
        product.setProductCategory((ProductCategory) productCategory);

        ProductType productType = productDTO.getProductType();
        product.setProductType(productType);

        product.setImageUrl(productDTO.getImageUrl());
        product.setProductStatus(productDTO.getProductStatus());

        Set<Author> author = this.authorRepository.findById(productDTO.getAuthor());
        product.setAuthor((Author) author);

        return this.productRepository.save(product);
    }

    public Product updateProduct(final ProductDTO productDTO, final Long productId){
        Product product = this.productRepository.findById(productId)
                .orElseThrow(()-> new NotFoundException(ErrorMessages.ID_NOT_FOUND_EXCEPTION));
        product.setProductName(productDTO.getProductName());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        product.setImageUrl(productDTO.getImageUrl());
        product.setProductType(productDTO.getProductType());
        product.setProductStatus(productDTO.getProductStatus());
        return product;
    }

}
