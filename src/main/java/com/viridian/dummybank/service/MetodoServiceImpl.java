package com.viridian.dummybank.service;


import com.viridian.dummybank.dao.MetodoRepository;
import com.viridian.dummybank.model.Metodo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MetodoServiceImpl implements MetodoService {
    @Autowired
    protected MetodoRepository metodoRepository;

    @Override
    public List<Metodo> getAll() {
        return this.metodoRepository.findAll();
    }

    @Override
    public void save(Metodo metodo) {
        this.metodoRepository.save(metodo);
    }

    @Override
    public void delete(Long id) {
        this.metodoRepository.delete(id);
    }

    @Override
    public Metodo getMetodoById(Long id) {
        return this.metodoRepository.findOne(id);
    }
}
