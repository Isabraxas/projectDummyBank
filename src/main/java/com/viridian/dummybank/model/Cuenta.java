package com.viridian.dummybank.model;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Table(name="Cuenta")
@Entity
@Access(AccessType.FIELD)
public class Cuenta implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_cuenta", nullable = false)
    private Long idCuenta;

    @Column(name = "numero_cuenta", nullable = false)
    private Long numeroCuenta;

    @Column(name = "tipo", nullable = false)
    private String tipo;

    @Column(name = "saldo", nullable = false)
    private BigDecimal saldo ;

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
}
