package online.store.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_Id")
    private Long id;

    private String login;

    private String password;

    private String firstName;
    private String lastName;

    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;

    @ManyToMany
    @JoinTable(name = "user_role",
            joinColumns =@JoinColumn(name = "user_id"),
            inverseJoinColumns =@JoinColumn(name = "role_id"))
    private Set<Role> roles;

    @OneToMany(mappedBy = "user")
    private Set<Order> orders;

    @OneToOne(mappedBy = "user")
    private Cart cart;
}
