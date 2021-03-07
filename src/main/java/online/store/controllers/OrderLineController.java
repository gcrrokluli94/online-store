package online.store.controllers;

import online.store.model.DTO.OrderLineDTO;
import online.store.model.OrderLine;
import online.store.model.errors.NotFoundException;
import online.store.services.OrderLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/api")
public class OrderLineController {

    @Autowired
    private OrderLineService orderLineService;

    @GetMapping("/order-line")
    public ResponseEntity<List<OrderLine>> getOrderLines(){
        return ResponseEntity.ok().body(orderLineService.returnAllOrderLine());
    }

    @PostMapping("/new-order-line")
    public ResponseEntity<OrderLine> saveOrderLine(@RequestBody @Valid final OrderLineDTO orderLineDTO) throws NotFoundException {
        OrderLine orderLine = this.orderLineService.saveTheOrderLine(orderLineDTO);
        return ResponseEntity.ok(orderLine);
    }

}
