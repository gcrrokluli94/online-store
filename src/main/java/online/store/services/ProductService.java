package online.store.services;

import online.store.model.Product;
import online.store.model.enumeration.ProductType;
import online.store.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

@Service
@Transactional
public class ProductService  {

        @Autowired
        private ProductRepository productRepository;

        public List<Product> readAllProduct(){
           return productRepository.findAll();
        }

        public List<Product> findAvaiableProduct(){return productRepository.findAvaiableProduct();}


        public List<Product> findProductDifferentAttributes(final String productName,
                                                            final Double productPrice,
                                                            final ProductType productType,
                                                            final String productCategory) {
        return productRepository.findByProductNameAndPriceAndProductTypeAndProductCategoriesName(productName, productPrice, productType, productCategory);

        }

}
