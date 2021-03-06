package online.store.repositories;


import online.store.model.Product;
import online.store.model.ProductCategory;
import online.store.model.enumeration.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {



    List<Product> findByProductNameAndPriceAndProductTypeAndProductCategoryName(final String productName,
                                                final Double productPrice,
                                                final ProductType productType,
                                                final String productCategory);

    List<Product> findByProductNameOrPriceOrProductTypeOrProductCategoryName(final String productName,
                                                                                final Double productPrice,
                                                                                final ProductType productType,
                                                                                final String productCategory);

    List<Product> findByProductName(final String productName);


    @Query(value = "SELECT * FROM product p WHERE p.product_name =:productName", nativeQuery = true)
    List<Product> findByProductNameNativeQuery(final String productName);


    @Query(value = "SELECT p.* FROM product p WHERE p.product_status ='IN_STOCK'", nativeQuery = true)
    List<Product> findAvaiableProduct();


}
