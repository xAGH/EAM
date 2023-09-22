package co.edu.eam.negocio.cliente.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.eam.negocio.cliente.entity.Cliente;
import co.edu.eam.negocio.cliente.services.ClienteServiceImp;

@RestController
@RequestMapping("cliente")
public class ClienteController {
    
    @Autowired
    ClienteServiceImp servicio;

    @GetMapping
    public ResponseEntity<List<Cliente>> getAll() {
        List<Cliente> clientes = servicio.listAllCliente();
        return clientes.isEmpty() 
            ? ResponseEntity.noContent().build()
            : ResponseEntity.ok(clientes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> getOne(@PathVariable("id") Long id){
        Cliente cliente = servicio.getCliente(id);
        return servicio == null
            ? ResponseEntity.notFound().build()
            : ResponseEntity.ok(cliente);
    }

    @PostMapping
    public ResponseEntity<Object> create(@Valid @RequestBody Cliente cliente, Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.badRequest().body(errors.getAllErrors());
        }
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(servicio.createCliente(cliente));
    }


    @PutMapping
    public ResponseEntity<Object> update(@Valid @RequestBody Cliente cliente, Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.badRequest().body(errors.getAllErrors());
        }
        if (servicio.getCliente(cliente.getId()) == null) {
            return ResponseEntity.notFound().build(); 
        }

        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(servicio.createCliente(cliente));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Cliente> delete(@PathVariable(required = true, name = "id") Long id) {
        if (id == null) return ResponseEntity.badRequest().body(null);
        return servicio.getCliente(id) == null 
            ? ResponseEntity.notFound().build()
            : ResponseEntity.ok(servicio.deleteCliente(id));
    }

}
