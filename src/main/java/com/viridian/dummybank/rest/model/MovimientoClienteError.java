package com.viridian.dummybank.rest.model;

import com.viridian.dummybank.error.ErrorNoEncontrado;

public class MovimientoClienteError {
    private Long idCliente;
    private Long numeroCuenta;
    private String estado;
    // Error
    private ErrorNoEncontrado error;

    public MovimientoClienteError (){}

    public MovimientoClienteError(Long idCliente, Long numeroCuenta, String estado, ErrorNoEncontrado error) {
        this.idCliente = idCliente;
        this.numeroCuenta = numeroCuenta;
        this.estado = estado;
        this.error = error;
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setNumeroCuenta(Long numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public ErrorNoEncontrado getError() {
        return error;
    }

    public void setError(ErrorNoEncontrado error) {
        this.error = error;
    }
}
