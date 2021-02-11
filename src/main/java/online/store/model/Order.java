package online.store.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import online.store.model.enumeration.OrderStatus;
import online.store.model.enumeration.PaymentMethod;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Order implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userName;
    private String userAddress;

    private LocalDateTime placedDate;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    private BigDecimal totalPrice;

    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;

    @OneToMany(mappedBy = "order")
    private Set<OrderLine> orderLines = new HashSet<>();

    @ManyToOne
    @JsonIgnoreProperties(value = "carts", allowSetters = true)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToMany
    @JoinTable(name = "order_client",
    joinColumns = @JoinColumn(name ="order_id"),
    inverseJoinColumns = @JoinColumn(name = "client_id"))
    private Set<Client> clients = new HashSet<>();
}
