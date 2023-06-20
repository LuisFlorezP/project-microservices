package com.users.ProyectUsers.controller;

import com.users.ProyectUsers.entity.User;
import com.users.ProyectUsers.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/users/new")
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        User request = userService.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(request);
    }

    @GetMapping("/users/{idUser}")
    public ResponseEntity<User> getUser (@PathVariable String idUser) {
        User user = userService.getUser(idUser);
        return ResponseEntity.ok(user);
    }

    @GetMapping("users/findAll")
    public ResponseEntity<List<User>> getAllUsers () {
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }
}
