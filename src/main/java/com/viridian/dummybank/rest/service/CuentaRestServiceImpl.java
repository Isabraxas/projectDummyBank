package com.viridian.dummybank.rest.service;

import com.viridian.dummybank.error.ErrorNoEncontrado;
import com.viridian.dummybank.error.NoEncontradoRestException;
import com.viridian.dummybank.rest.model.CuentaRestModel;
import com.viridian.dummybank.rest.repository.CuentaMapper;
import com.viridian.dummybank.service.CuentaServiceImpl;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CuentaRestServiceImpl implements CuentaRestService {

    private final Logger logger = org.slf4j.LoggerFactory.getLogger(CuentaServiceImpl.class);

    private final CuentaMapper cuentaRepository;

    @Autowired
    public CuentaRestServiceImpl(CuentaMapper cuentaRepository) {
        this.cuentaRepository = cuentaRepository;
    }

    @Transactional
    @Override
    public List<CuentaRestModel> getAllCuentas() {

        return cuentaRepository.findAllCuentas();
    }

    @Transactional
    @Override
    public CuentaRestModel getCuentaById(Long id) {
        CuentaRestModel cuenta = cuentaRepository.findCuentaById(id);

        if(cuenta == null){
            logger.error("No se encontro en la BD una cuenta con ID : "+ id);
            String errorMsg = "Cuenta ID: "+ id +" no encontrada";
            throw new NoEncontradoRestException(errorMsg, new ErrorNoEncontrado(id,"001","no se encontro en la BD una cuenta con este id.","Hemos encontrado un error intentelo mas tarde"));
        }
        return cuenta;
    }

    @Override
    public CuentaRestModel getCuentaWithCliente(Long id) {
        CuentaRestModel cuenta = cuentaRepository.findCuentaWithCliente(id);

        if(cuenta == null){
            logger.error("No se encontro en la BD una cuenta con ID : "+ id);
            String errorMsg = "Cuenta ID: "+ id +" no encontrada";
            throw new NoEncontradoRestException(errorMsg, new ErrorNoEncontrado(id,"001","no se encontro en la BD una cuenta con este id.","Hemos encontrado un error intentelo mas tarde"));
        }
        return cuenta;
    }

    @Override
    public void createCuenta(CuentaRestModel cuenta) {
        this.cuentaRepository.insertCuenta(cuenta);
    }

    @Override
    public CuentaRestModel updateCuenta(CuentaRestModel cuenta) {
        int regModificados = cuentaRepository.updateCuenta(cuenta);

        if (regModificados == 0) {
            logger.error("No se pudo modificar en la BD una cuenta con ID : "+ cuenta.getIdCuenta());
            String errorMsg = "Cuenta ID: "+ cuenta.getIdCuenta() +" no modificada";
            throw new NoEncontradoRestException(errorMsg, new ErrorNoEncontrado(cuenta.getIdCuenta(),"001","no se pudo modificar en la BD una cuenta con este id.","Posiblemente alulguno de los valores o propiedades no coincide con el formato adecuado"));
        }

        return this.getCuentaById(cuenta.getIdCuenta());
    }

    @Override
    public void deleteCuenta(CuentaRestModel cuenta) {
        this.getCuentaById(cuenta.getIdCuenta());
        this.cuentaRepository.deleteCuenta(cuenta);
    }


}
