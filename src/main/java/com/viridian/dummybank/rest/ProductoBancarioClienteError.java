package com.viridian.dummybank.rest;

import com.viridian.dummybank.error.ErrorNoEncontrado;

/**
 * Created by marcelo on 07-03-18
 */
public class ProductoBancarioClienteError {

    // cliente
    private Long idCliente;

    // estado
    private String estado;

    // error
    private ErrorNoEncontrado error;


    public ProductoBancarioClienteError() {
    }

    public ProductoBancarioClienteError(Long idCliente, String estado, ErrorNoEncontrado error) {
        this.idCliente = idCliente;
        this.estado = estado;
        this.error = error;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
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
