package com.viridian.dummybank.rest.service;

import com.viridian.dummybank.rest.model.CuentaRestModel;

import java.util.List;

public interface CuentaRestService {
    List<CuentaRestModel> getAllCuentas();

    CuentaRestModel getCuentaById(Long id);

    CuentaRestModel updateCuenta(CuentaRestModel cuenta);

    CuentaRestModel getCuentaWithCliente(Long id);

    void createCuenta(CuentaRestModel cuenta);

    void deleteCuenta(CuentaRestModel cuenta);
}
