package com.taller.votos.services;

import java.util.List;

import com.taller.votos.entities.LanguajeEntity;
import com.taller.votos.enums.OperationType;

public interface LanguajeService {
    
    public List<LanguajeEntity> list();
    public LanguajeEntity search(LanguajeEntity languaje);
    public void save(LanguajeEntity languaje);
    public void delete(LanguajeEntity languaje);
    public Boolean votes(LanguajeEntity languaje, OperationType operation);

}
