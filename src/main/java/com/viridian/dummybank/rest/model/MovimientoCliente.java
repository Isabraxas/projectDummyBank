package com.viridian.dummybank.rest.model;

import com.viridian.dummybank.model.*;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class MovimientoCliente {

    private Long idTransaccion;

    private Long numeroCuenta;

    private Timestamp fechaInicio ;

    private Long numeroOrden;

    private Operacion operacion;

    private BigDecimal monto ;

    private String moneda;

    private BigDecimal saldo ;

    private Beneficiario beneficiario;


}
