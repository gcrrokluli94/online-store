package online.store.controllers;

import online.store.model.Order;
import online.store.model.OrderLine;
import online.store.services.OrderLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api")
public class OrderLineController {

    @Autowired
    private OrderLineService orderLineService;

    @GetMapping("/order-line")
    public ResponseEntity<List<OrderLine>> getOrderLine(){
        return ResponseEntity.ok().body(orderLineService.returnAllOrderLine());
    }



}
