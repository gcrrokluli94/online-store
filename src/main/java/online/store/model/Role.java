package online.store.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Role implements Serializable, GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "roles",  fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<User> users;

    @Override
    public String getAuthority() {
        return name;
    }


}
