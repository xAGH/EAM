package co.edu.eam.negocio.servicio.repositories;

import co.edu.eam.negocio.servicio.entities.Categoria;
import co.edu.eam.negocio.servicio.entities.Servicio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ServicioRepository extends JpaRepository<Servicio, Long> {
    public List<Servicio> findByCategoria (Categoria categoria);
}
