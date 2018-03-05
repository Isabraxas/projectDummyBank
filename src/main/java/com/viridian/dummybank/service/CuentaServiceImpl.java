package com.viridian.dummybank.service;

import com.viridian.dummybank.dao.CuentaRepository;
import com.viridian.dummybank.model.Cliente;
import com.viridian.dummybank.model.Cuenta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class CuentaServiceImpl implements CuentaService{

    @Autowired
    protected CuentaRepository cuentaRepository;

    @Override
    public List<Cuenta> getAll() {
        return this.cuentaRepository.findAll();
    }

    @Override
    public Cuenta getCuenta(Long id) {
        return this.cuentaRepository.findOne(id);
    }

    @Override
    public void save(Cuenta cuenta) {
        this.cuentaRepository.save(cuenta);
    }

    @Override
    public void delete(Long id) {
        this.cuentaRepository.delete(id);
    }

    @Override
    public Cuenta getCuentaByNumber(Long number) {
        return this.cuentaRepository.findByNumeroCuentaEquals(number);
    }

    @Override
    public List<Cuenta> getCuentaByCliente(Cliente cliente) {
        return this.cuentaRepository.findAllByCliente(cliente);
    }

    @Override
    public List<Cuenta> getCuentaByClienteId(Long clienteId) {
        return this.cuentaRepository.findAllByClienteId(clienteId);
    }

    @Override
    public Cuenta getByTipoAndCliente(String tipo, Cliente cliente) {
        return this.cuentaRepository.findByTipoEqualsAndCliente(tipo, cliente);
    }


}
