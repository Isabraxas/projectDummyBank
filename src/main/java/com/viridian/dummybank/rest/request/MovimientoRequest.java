package com.viridian.dummybank.rest.request;

public class MovimientoRequest {
    private Long idCliente;
    private Long numeroCuenta;

    public MovimientoRequest(){}

    public MovimientoRequest(Long idCliente, Long numeroCuenta) {
        this.idCliente = idCliente;
        this.numeroCuenta = numeroCuenta;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public Long getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(Long numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }
}
