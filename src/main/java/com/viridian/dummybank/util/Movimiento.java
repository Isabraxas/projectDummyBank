package com.viridian.dummybank.util;

import java.sql.Timestamp;

public class Movimiento {
    private Long numeroCuenta;
    private Timestamp fechaInicioDesde;
    private Timestamp fechaInicioHasta;

    public Long getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(Long numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public Timestamp getFechaInicioDesde() {
        return fechaInicioDesde;
    }

    public void setFechaInicioDesde(Timestamp fechaInicioDesde) {
        this.fechaInicioDesde = fechaInicioDesde;
    }

    public Timestamp getFechaInicioHasta() {
        return fechaInicioHasta;
    }

    public void setFechaInicioHasta(Timestamp fechaInicioHasta) {
        this.fechaInicioHasta = fechaInicioHasta;
    }
}
