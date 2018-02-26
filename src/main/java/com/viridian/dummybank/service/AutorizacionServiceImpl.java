package com.viridian.dummybank.service;

import com.viridian.dummybank.dao.AutorizacionRepository;
import com.viridian.dummybank.model.Autorizacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutorizacionServiceImpl implements AutorizacionService{
    @Autowired
    protected AutorizacionRepository autorizacionRepository;

    @Override
    public List<Autorizacion> getAll() {
        return this.autorizacionRepository.findAll();
    }

    @Override
    public void save(Autorizacion autorizacion) {
        this.autorizacionRepository.save(autorizacion);
    }

    @Override
    public void delete(Long id) {
        this.autorizacionRepository.delete(id);
    }

    @Override
    public Autorizacion getAutorizacionById(Long id) {
        return this.autorizacionRepository.findOne(id);
    }
}
