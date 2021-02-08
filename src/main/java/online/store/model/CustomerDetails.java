package online.store.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "customer_details")
public class CustomerDetails implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String phone;
    private String shippingAddress;
    private String clientAddress;
    private String city;
    private String country;

    @OneToOne
    private User user;

    @OneToMany(mappedBy = "customerDetails")
    private Set<ShoppingCart> carts = new HashSet<>();
}
