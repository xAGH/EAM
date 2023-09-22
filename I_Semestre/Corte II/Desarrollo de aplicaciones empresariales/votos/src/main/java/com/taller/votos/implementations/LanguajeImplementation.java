package com.taller.votos.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.taller.votos.daos.LanguajeDao;
import com.taller.votos.entities.LanguajeEntity;
import com.taller.votos.enums.OperationType;
import com.taller.votos.services.LanguajeService;

@Service
public class LanguajeImplementation implements LanguajeService {

    @Autowired
    private LanguajeDao languajeDao;

    @Override
    @Transactional()
    public List<LanguajeEntity> list() {
        return (List<LanguajeEntity>) languajeDao.findAll();
    }

    @Override
    @Transactional()
    public LanguajeEntity search(LanguajeEntity languaje) {
        return languajeDao.findById(languaje.getId()).orElse(null);
    }

    @Override
    @Transactional()
    public void save(LanguajeEntity languaje) {
        languajeDao.save(languaje);
    }

    @Override
    @Transactional()
    public void delete(LanguajeEntity languaje) {
        languajeDao.delete(languaje);
    }

    @Override
    public Boolean votes(LanguajeEntity languaje, OperationType operationType) {
        LanguajeEntity languajeToVote = this.search(languaje);
        
        if (languajeToVote != null){
            languajeToVote.setVotes(
                (short) (languajeToVote.getVotes() + (operationType == OperationType.RESTA ? -1 : 1))
            );
            languajeDao.save(languajeToVote);
            return true;
        }

        return false;
    }
}
