package online.store.model;

import java.io.Serializable;

public class Cart implements Serializable {

    private User user;
    private Client client;
    private OrderLine orderLine;
}
