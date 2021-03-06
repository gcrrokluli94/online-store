package online.store.services;

import online.store.model.Order;
import online.store.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> readAllOrder() {
        return orderRepository.findAll();
    }

    public List<Order> readAllActivOrder(){
        return orderRepository.findAllActiveOrdersNativeQuery();
    }

}

