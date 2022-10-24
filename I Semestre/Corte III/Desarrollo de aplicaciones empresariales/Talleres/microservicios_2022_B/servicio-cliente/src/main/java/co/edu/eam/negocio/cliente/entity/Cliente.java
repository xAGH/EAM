package co.edu.eam.negocio.cliente.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.AccessLevel;

@Data
@Table
@Entity
public class Cliente implements Serializable{

    @Transient
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private final String PATRON_GENERO = "^M$|^F$";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre", nullable = false)
    private String nombre;

    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "apellido", nullable = false)
    private String apellido;

    @Email
    @Column(name = "email", nullable = false)
    private String email;

    @NotNull
    @Size(min = 10, max = 10)
    @Column(name = "telefono", nullable = false)
    private String telefono;
    
    @NotNull
    @Pattern(regexp = PATRON_GENERO)
    @Column(name = "genero", nullable = false)
    private String genero;

    @NotNull
    @Column(name = "created_at", columnDefinition = "TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP()")
    private LocalDateTime createdAt = LocalDateTime.now();

}
