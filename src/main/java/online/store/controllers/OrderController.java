package online.store.controllers;

import online.store.model.DTO.OrderDTO;
import online.store.model.Order;
import online.store.model.errors.NotFoundException;
import online.store.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/api")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/orders")
    public ResponseEntity<List<Order>> getOrders(){
        return ResponseEntity.ok().body(orderService.readAllOrder());
    }

    @GetMapping("/active-orders")
    public ResponseEntity<List<Order>> getActiveOrders(){
        return ResponseEntity.ok().body(orderService.readAllActivOrder());
    }

    @PostMapping("/new-order")
    public ResponseEntity<Order> saveOrder(@RequestBody @Valid final OrderDTO orderDTO) throws NotFoundException {
        Order order = this.orderService.saveTheOrder(orderDTO);
        return ResponseEntity.ok(order);
    }

    @PutMapping("/updateOrder/{orderId}")
    public ResponseEntity<Order> updateOrder(@RequestBody final OrderDTO orderDTO,  @PathVariable("orderId") final Long orderId) throws NotFoundException {
        Order order = this.orderService.updateTheOrder(orderDTO, orderId);
        return ResponseEntity.ok(order);
    }

}
