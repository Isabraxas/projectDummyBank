package com.viridian.dummybank.service;

import com.viridian.dummybank.dao.EstatusRepository;
import com.viridian.dummybank.model.Estatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstatusServiceImpl implements EstatusService {

    @Autowired
    protected EstatusRepository estatusRepository;

    @Override
    public List<Estatus> getAll() {
        return this.estatusRepository.findAll();
    }

    @Override
    public void save(Estatus estatus) {
        this.estatusRepository.save(estatus);
    }

    @Override
    public void delete(Long id) {
        this.estatusRepository.delete(id);
    }

    @Override
    public Estatus getEstatusById(Long id) {
        return this.estatusRepository.findOne(id);
    }
}
