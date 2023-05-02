package com.users.ProyectUsers.service.impl;

import com.users.ProyectUsers.entity.User;
import com.users.ProyectUsers.exceptions.ResourceNotFoundException;
import com.users.ProyectUsers.repository.UserRepository;
import com.users.ProyectUsers.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.UUID;

public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        String randomIdUser = UUID.randomUUID().toString();
        user.setId_usuario(randomIdUser);
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(String id_usuario) {
        return userRepository.findById(id_usuario).orElseThrow(() -> new ResourceNotFoundException("User not found with the id: " + id_usuario));
    }
}
