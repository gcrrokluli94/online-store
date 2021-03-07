package online.store.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User implements Serializable, UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
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

    @ManyToMany(fetch = FetchType.EAGER)
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

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }
    @Override
    public String getUsername() {
        return login;
    }
    @Override
    public boolean isAccountNonExpired() {
        return !isCredentialsExpired;
    }
    @Override
    public boolean isAccountNonLocked() {
        return !isCredentialsExpired;
    }
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    @Override
    public boolean isEnabled() {
        return isEnabled;
    }
}
