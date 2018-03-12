package com.viridian.dummybank.service;

import com.viridian.dummybank.dao.CuentaRepository;
import com.viridian.dummybank.error.ErrorNoEncontrado;
import com.viridian.dummybank.error.NoEncontradoRestException;
import com.viridian.dummybank.model.Cliente;
import com.viridian.dummybank.model.Cuenta;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class CuentaServiceImpl implements CuentaService{
    //Logger
    private final Logger log = org.slf4j.LoggerFactory.getLogger(CuentaServiceImpl.class);

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
        Cuenta cuenta = this.cuentaRepository.findByNumeroCuentaEquals(number);
        if(cuenta == null){
            log.error("Numero de cuenta: "+ number +" no encontrado en BD");
            // throw ERROR
            /*// ERROR REDIRECCIONANDO A PAGINA DE ERROR*/
            String errorMsg = "La cuenta con el numero: "+ number +" no fue encontrada";
            // ERROR REDIRECCIONANDO UNA CLASE ERROR
            throw new NoEncontradoRestException(errorMsg, new ErrorNoEncontrado(number,"001","no se encontro la cuenta en la BD","Hemos encontrado un error intentelo mas tarde"));
        }
        return cuenta;
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

    @Override
    public boolean existsByIdCuenta(Long idCuenta) {
        return this.cuentaRepository.existsByIdCuenta(idCuenta);
    }


}
