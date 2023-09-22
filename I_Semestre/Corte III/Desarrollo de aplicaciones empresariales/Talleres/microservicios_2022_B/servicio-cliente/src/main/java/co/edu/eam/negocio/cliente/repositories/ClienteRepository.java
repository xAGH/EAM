package co.edu.eam.negocio.cliente.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.eam.negocio.cliente.entity.Cliente;

public interface ClienteRepository extends JpaRepository <Cliente, Long> {}
