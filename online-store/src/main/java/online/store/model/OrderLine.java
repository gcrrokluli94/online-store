package online.store.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class OrderLine implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer quantity;
    private BigDecimal totalPrice;

    @ManyToOne
    @JsonIgnoreProperties(value = "orderLines", allowSetters = true)
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @JsonIgnoreProperties(value = "orders", allowSetters = true)
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name ="cart_id")
    private Cart cart;
}
