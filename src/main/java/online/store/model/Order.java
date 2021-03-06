package online.store.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import online.store.model.enumeration.OrderStatus;
import online.store.model.enumeration.PaymentMethod;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="orders")
public class Order implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long id;

    private LocalDateTime placedDate;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    private Double totalPrice;

    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;

    @OneToMany(mappedBy = "order",  fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<OrderLine> orderLine;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
