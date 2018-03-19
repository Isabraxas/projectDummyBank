package com.viridian.dummybank.rest.model;

import java.math.BigDecimal;

public class CuentaRestModel{

    private Long idCuenta;

    private Long numeroCuenta;

    private String tipo;

    private BigDecimal saldo ;

    private Long clienteId;

    private String moneda;

    public CuentaRestModel(){}
    public CuentaRestModel(Long idCuenta, Long numeroCuenta, String tipo, BigDecimal saldo, Long clienteId, String moneda) {
        this.idCuenta = idCuenta;
        this.numeroCuenta = numeroCuenta;
        this.tipo = tipo;
        this.saldo = saldo;
        this.clienteId = clienteId;
        this.moneda = moneda;
    }


//Getters and Setters


    public Long getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(Long idCuenta) {
        this.idCuenta = idCuenta;
    }

    public Long getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(Long numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }
}
