package com.viridian.dummybank.service;


import com.viridian.dummybank.dao.TransaccionRepository;
import com.viridian.dummybank.model.Transaccion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransaccionServiceImpl implements TransaccionService{
    @Autowired
    protected TransaccionRepository transaccionRepository;

    @Override
    public List<Transaccion> getAll() {
        return this.transaccionRepository.findAll();
    }

    @Override
    public void save(Transaccion transaccion) {
        this.transaccionRepository.save(transaccion);
    }

    @Override
    public void delete(Long id) {
        this.transaccionRepository.delete(id);
    }

    @Override
    public Transaccion getTransaccionById(Long id) {
        return this.transaccionRepository.findOne(id);
    }
}
