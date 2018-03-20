package com.viridian.dummybank.rest.repository;


import com.viridian.dummybank.rest.model.CuentaRestModel;
import org.apache.ibatis.annotations.*;

import java.util.List;


public interface CuentaMapper {


    List<CuentaRestModel> findAllCuentas();

    CuentaRestModel findCuentaById(Long id);

    // Procedimiento almacenado
    List<CuentaRestModel> findCuentaByIdCuenta(CuentaRestModel cuentaRestModel);

    //Join tablas cuenta y cliente
    CuentaRestModel findCuentaWithCliente(Long idCuenta);

    int updateCuenta(CuentaRestModel cuenta);

    void insertCuenta(CuentaRestModel cuenta);

    void deleteCuenta(CuentaRestModel cuenta);
}
