package com.viridian.dummybank.service;

import com.viridian.dummybank.dao.OperacionRepository;
import com.viridian.dummybank.model.Operacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OperacionServiceImpl implements OperacionService {
    @Autowired
    protected OperacionRepository operacionRepository;

    @Override
    public List<Operacion> getAll() {
        return this.operacionRepository.findAll();
    }

    @Override
    public void save(Operacion operacion) {
        this.operacionRepository.save(operacion);
    }

    @Override
    public void delete(Long id) {
        this.operacionRepository.delete(id);
    }

    @Override
    public Operacion getOperacionById(Long id) {
        return this.operacionRepository.findOne(id);
    }
}
