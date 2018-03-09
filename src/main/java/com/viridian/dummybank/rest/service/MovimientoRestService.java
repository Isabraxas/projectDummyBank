package com.viridian.dummybank.rest.service;

import com.viridian.dummybank.model.Transaccion;
import com.viridian.dummybank.rest.model.MovimientoCliente;
import com.viridian.dummybank.rest.request.MovimientoRequest;

import java.util.List;

public interface MovimientoRestService {
    List<MovimientoCliente> getMovimientoByCuenta(Long numeroCuenta);

    List<MovimientoCliente> getMovimientoByRangoFecha(Long numeroCuenta, String fechaDesde, String fechaHasta);

    List<MovimientoCliente> getMovimientoByCuentaAndUltimos(Long numeroCuenta, int numeroMovimientos);

    List<MovimientoCliente> getMovimientos(MovimientoRequest movimientoRequest);
}
