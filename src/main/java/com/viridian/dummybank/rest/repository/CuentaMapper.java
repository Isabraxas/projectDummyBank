package com.viridian.dummybank.rest.repository;


import com.viridian.dummybank.rest.model.CuentaRestModel;
import org.apache.ibatis.annotations.*;

import java.util.List;


public interface CuentaMapper {


    List<CuentaRestModel> findAllCuentas();

    CuentaRestModel findCuentaById(Long id);

    List<CuentaRestModel> findCuentaByIdCuenta(CuentaRestModel cuentaRestModel);

    int updateCuenta(CuentaRestModel cuenta);

    void insertCuenta(CuentaRestModel cuenta);

    void deleteCuenta(CuentaRestModel cuenta);
}
