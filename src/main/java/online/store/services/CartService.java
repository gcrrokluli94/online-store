package online.store.services;

import online.store.model.Cart;
import online.store.repositories.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    public List<Cart> realAllCart() { return cartRepository.findAll(); }

}
