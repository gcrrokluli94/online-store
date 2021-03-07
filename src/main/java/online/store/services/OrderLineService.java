package online.store.services;

import lombok.extern.slf4j.Slf4j;
import online.store.model.*;
import online.store.model.DTO.OrderLineDTO;
import online.store.model.errors.NotFoundException;
import online.store.repositories.CartRepository;
import online.store.repositories.OrderLineRepository;
import online.store.repositories.OrderRepository;
import online.store.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import java.util.List;

@Service
@Transactional
@Slf4j
public class OrderLineService {

    @Autowired
    private OrderLineRepository orderLineRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CartRepository cartRepository;


    public List<OrderLine> returnAllOrderLine(){ return orderLineRepository.findAll();}

    public OrderLine getOrderLineById(final Long orderLine) {
        return orderLineRepository.findById(orderLine).orElseThrow(() -> new NotFoundException("Produkti nuk u gjet"));
    }


    public OrderLine saveTheOrderLine(final OrderLineDTO orderLineDTO) {
        OrderLine orderLine = new OrderLine();

        Product product = this.productRepository.findById(orderLineDTO.getProductId()).orElseThrow(()->{
          return new NotFoundException("Produkti nuk u gjet"); });
        orderLine.setProduct(product);

        Cart cart = this.cartRepository.findById(orderLineDTO.getCardId()).orElseThrow(()->{
            return new NotFoundException("Cart-a  nuk u gjet");  });
        orderLine.setCart(cart);

        Order order = this.orderRepository.findById(orderLineDTO.getOrderId()).orElseThrow(()->{
            return new NotFoundException("Order-i  nuk u gjet");  });
        orderLine.setOrder(order);

        orderLine.setTotalPrice(orderLineDTO.getTotalPrice());
        orderLine.setQuantity(orderLineDTO.getQuantity());
        return this.orderLineRepository.save(orderLine);
    }

}
