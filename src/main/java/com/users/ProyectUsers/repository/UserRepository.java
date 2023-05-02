package com.users.ProyectUsers.repository;

import com.users.ProyectUsers.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
