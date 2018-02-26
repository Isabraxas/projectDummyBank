package com.viridian.dummybank.util;

import java.sql.Timestamp;

public class Movimiento {
    private Long numeroCuenta;
    private int opcion;
    private Timestamp fechaInicioDesde;
    private Timestamp fechaInicioHasta;


    public Long getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(Long numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public int getOpcion() {
        return opcion;
    }

    public void setOpcion(int opcion) {
        this.opcion = opcion;
    }

    public Timestamp getFechaInicioDesde() {
       // if (fechaInicioDesde.toString() == ""){
         //   return Timestamp.valueOf("0000-00-00 00:00:00");
       // }
        return fechaInicioDesde;
    }

    public void setFechaInicioDesde(Timestamp fechaInicioDesde) {
        this.fechaInicioDesde = fechaInicioDesde;
    }

    public Timestamp getFechaInicioHasta() {
      //  if (fechaInicioHasta.toString() == ""){
        //    return Timestamp.valueOf("0000-00-00 00:00:00");
       // }
        return fechaInicioHasta;
    }

    public void setFechaInicioHasta(Timestamp fechaInicioHasta) {
        this.fechaInicioHasta = fechaInicioHasta;
    }
}
