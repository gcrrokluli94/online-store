package online.store.services;
import lombok.extern.slf4j.Slf4j;
import online.store.model.DTO.OrderDTO;
import online.store.model.Order;
import online.store.model.Role;
import online.store.model.User;
import online.store.model.constants.ErrorMessages;
import online.store.model.enumeration.OrderStatus;
import online.store.model.errors.NotFoundException;
import online.store.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
@Slf4j
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserService userService;

    public List<Order> readAllOrder() {
        return orderRepository.findAll();
    }

    public List<Order> readAllActivOrder(){
        return orderRepository.findAllActiveOrdersNativeQuery();
    }


    public Order saveTheOrder(final OrderDTO orderDTO) {
        Order order = new Order();
        order.setTotalPrice(orderDTO.getTotalPrice());
        order.setPlacedDate(LocalDateTime.now());
        order.setPaymentMethod(orderDTO.getPaymentMethod());
        order.setOrderStatus(OrderStatus.PENDING);
        User user = this.userService.readUserById(orderDTO.getUserId());
        order.setUser(user);
        return this.orderRepository.save(order);
    }

    public Order updateTheOrder(final OrderDTO orderDTO, final Long orderId) {
        Order order = this.orderRepository.findById(orderId)
                .orElseThrow(() -> new NotFoundException(ErrorMessages.ID_NOT_FOUND_EXCEPTION));;
        order.setPlacedDate(LocalDateTime.now());
        order.setPaymentMethod(orderDTO.getPaymentMethod());
        order.setOrderStatus(OrderStatus.PENDING);
        OrderService.log.info("Order Updated successfully");
        return order;
    }

}

