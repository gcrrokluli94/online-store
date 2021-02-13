package online.store.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Cart implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(name = "user_id")
    private User user;


    private OrderLine orderLine;
}
