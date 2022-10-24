package co.edu.eam.negocio.servicio.services;

import co.edu.eam.negocio.servicio.entities.Categoria;
import co.edu.eam.negocio.servicio.entities.Servicio;
import co.edu.eam.negocio.servicio.repositories.ServicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioImplementacion implements ServicioService{
    @Autowired
    private ServicioRepository servicioRepository;

    @Override
    public List<Servicio> listAllServicio() {
        return servicioRepository.findAll();
    }

    @Override
    public Servicio getServicio(Long id) {
        return servicioRepository.findById(id).orElse(null);
    }

    @Override
    public Servicio createServicio(Servicio servicio) {
        servicio.setEstado("ACTIVO");
        return servicioRepository.save(servicio);
    }

    @Override
    public Servicio updateServicio(Servicio servicio) {
        Servicio servicioBD = getServicio(servicio.getId());

        servicioBD.setNombre(servicio.getNombre());
        servicioBD.setDescripcion(servicio.getDescripcion());
        servicioBD.setPrecio(servicio.getPrecio());
        servicioBD.setCategoria(servicio.getCategoria());
        return servicioRepository.save(servicioBD);
    }

    @Override
    public Servicio deleteServicio(Long id) {
        Servicio servicioBD = getServicio(id);
        servicioBD.setEstado("ELIMINADO");
        return servicioRepository.save(servicioBD);
    }

    @Override
    public List<Servicio> findByCategoria(Categoria categoria) {
        return servicioRepository.findByCategoria(categoria);
    }
}
