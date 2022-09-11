package com.parciales.parcial1.domain;
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
@Entity
@Table(name = "cars")
public class Car implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Size(min = 2, max = 30)
    private String brand;

    @NotNull
    @Size(min = 2, max = 10)
    private String model;

    @NotNull
    @Pattern(regexp = "\\d{4}", message = "La fecha debe de tener 4 digitos")
    private String year;

    @NotNull
    private String type;

    @NotNull
    @Pattern(regexp = "^[1-9][0-9]?$|^100$", message = "El valor debe de estar entre 1 y 100")
    private String engineCylinders;
    
    @NotNull
    private String fuelType;
}
