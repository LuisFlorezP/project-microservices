package com.users.ProyectUsers.controller;

import com.users.ProyectUsers.entities.User;
import com.users.ProyectUsers.service.UserService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Slf4j
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
    @CircuitBreaker(name = "ratingHotelBreaker", fallbackMethod = "ratingHotelFallback")
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

    public ResponseEntity<User> ratingHotelFallback(Exception exception) {
        log.info("Backup runs because the service is down", exception.getMessage());
        return new ResponseEntity<>(User.builder()
                .name("root")
                .idUser("123")
                .email("root@gmail.com")
                .year(0)
                .build(), HttpStatus.OK);
    }
}
