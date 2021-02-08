package online.store.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name="product_order")
public class ProductOrder implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer quantity;
    private BigDecimal totalPrice;

    @ManyToOne
    @JsonIgnoreProperties(value = "productOrders", allowSetters = true)
    private Product product;

    @ManyToOne
    @JsonIgnoreProperties(value = "orders", allowSetters = true)
    private ShoppingCart cart;
}
