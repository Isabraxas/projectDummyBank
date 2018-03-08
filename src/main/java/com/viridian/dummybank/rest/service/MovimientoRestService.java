package com.viridian.dummybank.rest.service;

import com.viridian.dummybank.model.Transaccion;

import java.util.List;

public interface MovimientoRestService {
    List<Transaccion> getMovimientoByCuenta(Long numeroCuenta);
}
