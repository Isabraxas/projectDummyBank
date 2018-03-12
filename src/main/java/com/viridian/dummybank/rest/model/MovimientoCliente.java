package com.viridian.dummybank.rest.model;

import com.viridian.dummybank.model.*;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class MovimientoCliente {

    private Long idTransaccion;

    private Long numeroCuenta;

    private Long cliente_id;

    private Timestamp fechaInicio ;

    private Long numeroOrden;

    private Operacion operacion;

    private BigDecimal monto ;

    private String moneda;

    private BigDecimal saldo ;

    private Beneficiario beneficiario;

    //Constructores
    public MovimientoCliente(){}

    public MovimientoCliente(Long idTransaccion, Long numeroCuenta, Long cliente_id, Timestamp fechaInicio, Long numeroOrden, Operacion operacion, BigDecimal monto, String moneda, BigDecimal saldo, Beneficiario beneficiario) {
        this.idTransaccion = idTransaccion;
        this.numeroCuenta = numeroCuenta;
        this.cliente_id = cliente_id;
        this.fechaInicio = fechaInicio;
        this.numeroOrden = numeroOrden;
        this.operacion = operacion;
        this.monto = monto;
        this.moneda = moneda;
        this.saldo = saldo;
        this.beneficiario = beneficiario;
    }


    //Getters and Setters

    public Long getIdTransaccion() {
        return idTransaccion;
    }

    public void setIdTransaccion(Long idTransaccion) {
        this.idTransaccion = idTransaccion;
    }

    public Long getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(Long numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public Long getCliente_id() {
        return cliente_id;
    }

    public void setCliente_id(Long cliente_id) {
        this.cliente_id = cliente_id;
    }

    public Timestamp getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Timestamp fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Long getNumeroOrden() {
        return numeroOrden;
    }

    public void setNumeroOrden(Long numeroOrden) {
        this.numeroOrden = numeroOrden;
    }

    public Operacion getOperacion() {
        return operacion;
    }

    public void setOperacion(Operacion operacion) {
        this.operacion = operacion;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public Beneficiario getBeneficiario() {
        return beneficiario;
    }

    public void setBeneficiario(Beneficiario beneficiario) {
        this.beneficiario = beneficiario;
    }
}
