package online.store.services;

import online.store.model.OrderLine;
import online.store.repositories.OrderLineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderLineService {

    @Autowired
    private OrderLineRepository orderLineRepository;

    public List<OrderLine> returnAllOrderLine(){ return orderLineRepository.findAll();}


}
