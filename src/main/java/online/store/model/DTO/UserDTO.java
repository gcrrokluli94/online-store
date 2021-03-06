package online.store.model.DTO;

import lombok.*;
import online.store.model.Address;
import online.store.model.Role;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserDTO {

    @NotNull
    @NotEmpty(message = "Required field")
    private String login;
    private String firstName;
    private String lastName;
    private String password;
    private String email;

    private boolean isAccountLocked;
    private boolean isCredentialsExpired;
    private boolean isEnabled;

    private Role rolesIDs;
    private Address address;


}

