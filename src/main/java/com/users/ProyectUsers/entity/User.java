package com.users.ProyectUsers.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User {

    @Id
    @Column(name = "id_usuario")
    private String id_usuario;
    @Column(name = "name")
    private String name;
    @Column(name = "year")
    private int year;
    @Column(name = "email")
    private String email;
}
