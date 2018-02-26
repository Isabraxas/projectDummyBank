package com.viridian.dummybank.service;


import com.viridian.dummybank.dao.TransaccionRepository;
import com.viridian.dummybank.model.Transaccion;
import com.viridian.dummybank.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
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

    @Override
    public List<Transaccion> getTransaccionGreaterTo(String fechaA, String fechaB) {
        //Timestamp fechaInicio= Util.convertStringToTimestamp(fecha);
        //return this.transaccionRepository.findByFechaInicioGreaterThanEqual(fechaInicio);
        Timestamp fechaInicioA= Util.convertStringToTimestamp(fechaA);
        Timestamp fechaInicioB= Util.convertStringToTimestamp(fechaB);
        return this.transaccionRepository.findByFechaInicioBetween(fechaInicioA, fechaInicioB);
    }

    @Override
    public List<Transaccion> getTransaccionByCuenta(Long numeroCuenta) {
        return this.transaccionRepository.findByNumeroCuentaEquals(numeroCuenta);
    }

    @Override
    public List<Transaccion> getTransaccionByCuentaAndMoneda(Long numeroCuenta, String moneda) {
        return this.transaccionRepository.findByNumeroCuentaEqualsAndMonedaEquals(numeroCuenta, moneda);
    }

    @Override
    public List<Transaccion> getTransaccionByCuentaAndPeriod(Long numeroCuenta, String fechaA, String fechaB) {
        Timestamp fechaInicioA= Util.convertStringToTimestamp(fechaA);
        Timestamp fechaInicioB= Util.convertStringToTimestamp(fechaB);
        return this.transaccionRepository.findByNumeroCuentaEqualsAndFechaInicioBetween(numeroCuenta,fechaInicioA,fechaInicioB);
    }


}
