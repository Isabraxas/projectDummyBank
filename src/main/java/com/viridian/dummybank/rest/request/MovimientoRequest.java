package com.viridian.dummybank.rest.request;

public class MovimientoRequest {
    private Long idCliente;
    private Long numeroCuenta;
    private String fechaDesde;
    private String fechaHasta;
    private int numeroMovimientos;

    public MovimientoRequest(){}

    public MovimientoRequest(Long idCliente, Long numeroCuenta) {
        this.idCliente = idCliente;
        this.numeroCuenta = numeroCuenta;
    }

    public MovimientoRequest(Long idCliente, Long numeroCuenta, String fechaDesde, String fechaHasta) {
        this.idCliente = idCliente;
        this.numeroCuenta = numeroCuenta;
        this.fechaDesde = fechaDesde;
        this.fechaHasta = fechaHasta;
    }

    public MovimientoRequest(Long idCliente, Long numeroCuenta, int numeroMovimientos) {
        this.idCliente = idCliente;
        this.numeroCuenta = numeroCuenta;
        this.numeroMovimientos = numeroMovimientos;
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

    public String getFechaDesde() {
        return fechaDesde;
    }

    public void setFechaDesde(String fechaDesde) {
        this.fechaDesde = fechaDesde;
    }

    public String getFechaHasta() {
        return fechaHasta;
    }

    public void setFechaHasta(String fechaHasta) {
        this.fechaHasta = fechaHasta;
    }

    public int getNumeroMovimientos() {
        return numeroMovimientos;
    }

    public void setNumeroMovimientos(int numeroMovimientos) {
        this.numeroMovimientos = numeroMovimientos;
    }
}
