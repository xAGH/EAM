package com.taller.votos.entities;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;

@Entity
@Data
@Table(name="admins")
public class AdminEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false, length = 40)
    @NotNull(message = "El nombre no puede estar vacío")
    @Size(min = 1, max = 40)
    private String name;

    @Column(name = "email", nullable = false, unique = true)
    @Email(message = "El campo debe ser un correo válido")
    private String email;

    @Column(name = "password", nullable = false)
    @NotNull(message = "La contraseña no puede estar vacía")
    private String password;

}
