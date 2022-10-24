package com.taller.votos.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.taller.votos.entities.AdminEntity;

public interface AdminDao extends JpaRepository<AdminEntity, Long> {
    
    AdminEntity findByEmail(String email);

}
