package online.store.controllers;


import online.store.model.DTO.UserDTO;
import online.store.model.User;
import online.store.model.errors.NotFoundException;

import online.store.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/user")
    public ResponseEntity<User> postUser(@RequestBody @Valid final UserDTO userDTO) throws NotFoundException {
        User user = this.userService.saveTheUser(userDTO);
        return ResponseEntity.ok(user);
    }

    @PutMapping("/user/{userId}/")
    public ResponseEntity<User> putUser(@RequestBody final UserDTO userDTO, @PathVariable("userId") final Long userId) throws NotFoundException {
        User user = this.userService.updateTheUser(userDTO, userId);
        return ResponseEntity.ok(user);

    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers() {
        List<User> users = this.userService.readAllTheUsers();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<User> getUser(@PathVariable("userId") final Long userId) throws NotFoundException {
        User user = this.userService.readUserById(userId);
        return ResponseEntity.ok(user);
    }

}

