package com.users.ProyectUsers.controller;

import com.users.ProyectUsers.entity.User;
import com.users.ProyectUsers.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/users")
@Tag(name = "Services of Users", description = "Services to the User entity.")
public class UserController {

    @Autowired
    private UserService userService;

    @Operation(summary = "Method to save a user register.")
    @PostMapping("/new")
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        User request = userService.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(request);
    }

    @Operation(summary = "Method to get a user register.")
    @GetMapping("/{idUser}")
    public ResponseEntity<User> getUser (@PathVariable String idUser) {
        User user = userService.getUser(idUser);
        return ResponseEntity.ok(user);
    }

    @Operation(summary = "Method to get all user registers.")
    @GetMapping("/findAll")
    public ResponseEntity<List<User>> getAllUsers () {
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }
}
