package online.store.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import online.store.model.enumeration.OrderStatus;
import online.store.model.enumeration.PaymentMethod;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="orders")
public class Order implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_Id")
    private Long id;

    private LocalDateTime placedDate;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    private BigDecimal totalPrice;

    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;

    @OneToMany(mappedBy = "order")
    private Set<OrderLine> orderLines;

    @ManyToOne
    @JsonIgnoreProperties(value = "orders", allowSetters = true)
    @JoinColumn(name = "user_id")
    private User user;
}
