package com.viridian.dummybank.rest.error;

import com.viridian.dummybank.error.ErrorNoEncontrado;


public class CuentaRestError {
    // cuenta
    private Long idCuenta;

    // estado
    private String estado;

    // error
    private ErrorNoEncontrado error;

    public CuentaRestError(){}

    public CuentaRestError(Long idCuenta, String estado, ErrorNoEncontrado error) {
        this.idCuenta = idCuenta;
        this.estado = estado;
        this.error = error;
    }

    public Long getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(Long idCuenta) {
        this.idCuenta = idCuenta;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public ErrorNoEncontrado getError() {
        return error;
    }

    public void setError(ErrorNoEncontrado error) {
        this.error = error;
    }
}
