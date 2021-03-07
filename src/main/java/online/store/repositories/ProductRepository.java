package online.store.repositories;


import online.store.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByProductNameAndPriceAndProductTypeAndProductCategoryName(final String productName,
                                                                                final String productPrice,
                                                                                final String productType,
                                                                                final String productCategory);

}
