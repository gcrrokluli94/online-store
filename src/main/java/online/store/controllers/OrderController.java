package online.store.controllers;

import online.store.model.Order;
import online.store.model.Product;
import online.store.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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




}
