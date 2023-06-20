package com.users.ProyectUsers.service;

import com.users.ProyectUsers.entity.User;

import java.util.List;

public interface UserService {

    User saveUser(User user);

    List<User> getAllUsers();

    User getUser(String idUser);
}
