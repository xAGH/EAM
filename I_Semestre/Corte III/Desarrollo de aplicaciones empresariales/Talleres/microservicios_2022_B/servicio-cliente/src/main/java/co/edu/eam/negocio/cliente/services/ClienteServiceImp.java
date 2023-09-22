package co.edu.eam.negocio.cliente.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.eam.negocio.cliente.entity.Cliente;
import co.edu.eam.negocio.cliente.repositories.ClienteRepository;

@Service
public class ClienteServiceImp implements ClienteService {

    @Autowired
    ClienteRepository clienteRepository;

    @Override
    public List<Cliente> listAllCliente() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente getCliente(Long id) {
        return clienteRepository.findById(id).orElse(null);
    }

    @Override
    public Cliente createCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public Cliente updateCliente(Cliente cliente) {
        return this.createCliente(cliente);
    }

    @Override
    public Cliente deleteCliente(Long id) {
        Cliente deleted = this.getCliente(id);
        clienteRepository.deleteById(id);
        return deleted;
    }
    
}
