package online.store.repositories;

import online.store.model.Cart;
import online.store.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {

    List<Product> findByUserId(final String userId);

}
