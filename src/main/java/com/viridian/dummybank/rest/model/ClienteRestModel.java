package com.viridian.dummybank.rest.model;

import java.util.List;

public class ClienteRestModel {

    private Long idCliente;

    private String tipo;

    private List<CuentaRestModel> cuentas;

    //Constructors
    public ClienteRestModel() {
    }


    //Getters and Setters
    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public List<CuentaRestModel> getCuentas() {
        return cuentas;
    }

    public void setCuentas(List<CuentaRestModel> cuentas) {
        this.cuentas = cuentas;
    }
}
