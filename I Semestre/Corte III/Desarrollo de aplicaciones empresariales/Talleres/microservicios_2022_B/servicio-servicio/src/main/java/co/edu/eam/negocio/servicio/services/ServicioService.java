package co.edu.eam.negocio.servicio.services;

import co.edu.eam.negocio.servicio.entities.Categoria;
import co.edu.eam.negocio.servicio.entities.Servicio;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ServicioService {
    public List<Servicio> listAllServicio();
    public Servicio getServicio(Long id);
    public Servicio createServicio(Servicio servicio);
    public Servicio updateServicio(Servicio servicio);
    public Servicio deleteServicio(Long id);
    public List<Servicio> findByCategoria(Categoria categoria);
}
