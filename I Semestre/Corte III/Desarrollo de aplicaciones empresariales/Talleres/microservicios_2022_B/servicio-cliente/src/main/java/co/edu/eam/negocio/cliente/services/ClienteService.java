package co.edu.eam.negocio.cliente.services;

import java.util.List;

import co.edu.eam.negocio.cliente.entity.Cliente;

public interface ClienteService {
    
    public List<Cliente> listAllCliente();
    public Cliente getCliente(Long id);
    public Cliente createCliente(Cliente cliente);
    public Cliente updateCliente(Cliente cliente);
    public Cliente deleteCliente(Long id);

}
