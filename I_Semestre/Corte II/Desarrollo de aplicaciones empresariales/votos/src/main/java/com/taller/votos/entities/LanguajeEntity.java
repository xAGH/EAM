package com.taller.votos.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;;

@Entity
@Data
@Table(name="languajes")
public class LanguajeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false, length = 40)
    @NotNull
    @Size(min = 1, max = 40)
    private String name;

    @Column(name = "description", nullable = false)
    @NotNull
    @Size(min = 1, max = 255)
    private String description;

    @Column(name = "votes", nullable = false, columnDefinition = "integer default 0")
    @NotNull
    private Short votes;

    @Lob
    @Column(name = "image_url", nullable = false)
    @NotNull
    private String images_url;

}
