package online.store.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
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
    private String email;

    private boolean isAccountLocked;
    private boolean isCredentialsExpired;
    private boolean isEnabled;


    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;

//    @ManyToMany
//    @JoinColumn(name = "role_id")
//    private Role role;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_role",
            joinColumns =@JoinColumn(name = "user_id"),
            inverseJoinColumns =@JoinColumn(name = "role_id"))
    private Set<Role> roles;

    @OneToMany(mappedBy = "user" , fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Order> orders;

    @OneToOne(mappedBy = "user", fetch = FetchType.LAZY)
    @JsonIgnore
    private Cart cart;
}
