package online.store.repositories;

import online.store.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    @Query(value = "SELECT * FROM orders  WHERE order_status<> 'CANCELLED'", nativeQuery = true)
    List<Order> findAllActiveOrdersNativeQuery();

}
