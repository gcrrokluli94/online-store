package online.store.services;


import lombok.extern.slf4j.Slf4j;

import online.store.model.DTO.UserDTO;
import online.store.model.Role;
import online.store.model.User;
import online.store.model.constants.ErrorMessages;
import online.store.model.errors.NotFoundException;
import online.store.repositories.RoleRepository;
import online.store.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    public User saveTheUser(final UserDTO userDTO) {

        User user = new User();

        Set<Role> roles = userDTO.getRoleIds().stream().map((roleId) -> {
           return this.roleRepository.findById(roleId).orElseThrow(() -> new NotFoundException("Roli me id e dhene nuk gjendet"));
        }).collect(Collectors.toSet());

        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());

        user.setLogin(userDTO.getLogin());
        user.setPassword(userDTO.getPassword());
        user.setRoles(roles);
        UserService.log.info("User saved successfully");
        return this.userRepository.save(user);
    }

    public User updateTheUser(final UserDTO userDTO, final Long userId) {

        User user = this.userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException(ErrorMessages.ID_NOT_FOUND_EXCEPTION));
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setLogin(userDTO.getLogin());
        user.setPassword(userDTO.getPassword());
        UserService.log.info("User updated successfully");
        return user;
    }

    public List<User> readAllTheUsers() {
        return this.userRepository.findAll();
    }

    public User readUserById(final Long userId) {
        return this.userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException(ErrorMessages.ID_NOT_FOUND_EXCEPTION));
    }


}
