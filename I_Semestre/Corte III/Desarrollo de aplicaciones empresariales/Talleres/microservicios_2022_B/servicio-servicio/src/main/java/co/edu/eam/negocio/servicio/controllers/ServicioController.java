package co.edu.eam.negocio.servicio.controllers;

import co.edu.eam.negocio.servicio.entities.Categoria;
import co.edu.eam.negocio.servicio.entities.Servicio;
import co.edu.eam.negocio.servicio.services.ServicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/services")
public class ServicioController {

    @Autowired
    private ServicioService servicioService;

    @GetMapping
    public ResponseEntity<List<Servicio>> listServicios(@RequestParam(name = "categoriaId", required = false) Long categoriaId){
        List<Servicio> servicios;
        if(categoriaId == null){
            servicios = servicioService.listAllServicio();
            if(servicios.isEmpty()){
                return ResponseEntity.noContent().build();
            }
        } else {
            servicios = servicioService.findByCategoria(Categoria.builder().id(categoriaId).build());
            if(servicios.isEmpty()){
                return ResponseEntity.noContent().build();
            }
        }
        return ResponseEntity.ok(servicios);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Servicio> obtener(@PathVariable("id") Long id){
        Servicio servicio = servicioService.getServicio(id);
        if(servicio == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(servicio);
    }

    @PostMapping
    public ResponseEntity<Servicio> registrar(@RequestBody Servicio servicio){
        Servicio objeto = servicioService.createServicio(servicio);
        return ResponseEntity.status(HttpStatus.CREATED).body(objeto);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Servicio> actualizar(@PathVariable("id") Long id, @RequestBody Servicio servicio){
        servicio.setId(id);
        Servicio servicioActualizado = servicioService.updateServicio(servicio);
        if(servicioActualizado == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(servicioActualizado);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<Servicio> eliminar(@PathVariable("id") Long id){
        Servicio servicio = servicioService.deleteServicio(id);
        if(servicio == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(servicio);
    }

}
