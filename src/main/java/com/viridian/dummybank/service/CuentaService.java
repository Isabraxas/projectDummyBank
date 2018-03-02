package com.viridian.dummybank.service;

import com.viridian.dummybank.model.Cuenta;

import java.math.BigDecimal;
import java.util.List;

public interface CuentaService {
    /**
     *
     * @return
     */
    List<Cuenta> getAll();

    /**
     *
     * @param id
     * @return
     */
    Cuenta getCuenta(Long id);

    /**
     *
     * @param cuenta
     */
    void save(Cuenta cuenta);

    /**
     *
     * @param id
     */
    void delete(Long id);

    Cuenta getCuentaByNumber(Long number);
}
