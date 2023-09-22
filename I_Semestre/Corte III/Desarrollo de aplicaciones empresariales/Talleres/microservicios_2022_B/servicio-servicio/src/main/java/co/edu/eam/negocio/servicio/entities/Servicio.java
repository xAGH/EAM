package co.edu.eam.negocio.servicio.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "servicio")
public class Servicio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String nombre;
    private String descripcion;
    private Double precio;
    private String estado;
    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;
}
