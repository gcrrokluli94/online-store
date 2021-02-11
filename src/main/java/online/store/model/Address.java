package online.store.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Address implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private String phone;
    private String shippingAddress;
    private String clientAddress;
    private String city;
    private String country;
    private String zipCode;

    @OneToOne(mappedBy = "address")
    private User user;

    @OneToOne(mappedBy = "address")
    private Client client;
}
