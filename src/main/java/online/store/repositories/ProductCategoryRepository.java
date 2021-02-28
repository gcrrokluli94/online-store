package online.store.repositories;

import online.store.model.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface ProductCategoryRepository  extends JpaRepository<ProductCategory, Long> {

}
