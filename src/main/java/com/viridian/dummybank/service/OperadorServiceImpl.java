package com.viridian.dummybank.service;


import com.viridian.dummybank.dao.OperadorRepository;
import com.viridian.dummybank.model.Operador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OperadorServiceImpl implements OperadorService{
    @Autowired
    protected OperadorRepository operadorRepository;

    @Override
    public List<Operador> getAll() {
        return this.operadorRepository.findAll();
    }

    @Override
    public void save(Operador operador) {
        this.operadorRepository.save(operador);
    }

    @Override
    public void delete(Long id) {
        this.operadorRepository.delete(id);
    }

    @Override
    public Operador getOperadorById(Long id) {
        return this.operadorRepository.findOne(id);
    }
}
