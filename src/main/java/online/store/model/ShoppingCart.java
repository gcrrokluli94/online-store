package online.store.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import online.store.model.enumeration.OrderStatus;
import online.store.model.enumeration.PaymentMethod;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name="shopping_cart")
public class ShoppingCart implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Instant placedDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private OrderStatus orderStatus;

    private BigDecimal totalPrice;

    @Enumerated(EnumType.STRING)
    @Column(name = "payment_method", nullable = false)
    private PaymentMethod paymentMethod;

    @OneToMany(mappedBy = "cart")
    private Set<ProductOrder> orders = new HashSet<>();

    @ManyToOne
    @JsonIgnoreProperties(value = "carts", allowSetters = true)
    private CustomerDetails customerDetails;
}
