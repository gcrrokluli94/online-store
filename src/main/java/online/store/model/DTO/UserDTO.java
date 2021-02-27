package online.store.model.DTO;

import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
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

    private List<Long> roleIds;


}

