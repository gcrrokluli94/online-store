package online.store.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Address implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private Long id;

    private String phone;
    private String shippingAddress;
    private String clientAddress;
    private String city;
    private String country;
    private String zipCode;

    @OneToOne(mappedBy = "address",  fetch = FetchType.LAZY)
    @JsonIgnore
    private User user;
}
