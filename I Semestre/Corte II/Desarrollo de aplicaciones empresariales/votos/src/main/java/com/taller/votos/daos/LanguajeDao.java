package com.taller.votos.daos;
import org.springframework.data.repository.CrudRepository;

import com.taller.votos.entities.LanguajeEntity;

public interface LanguajeDao extends CrudRepository<LanguajeEntity, Long>{}
