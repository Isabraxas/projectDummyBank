package com.viridian.dummybank.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;
import java.io.Serializable;
import java.math.BigDecimal;

@Table(name="cuenta")
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
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="cliente_id")
    @JsonIgnore
    private Cliente cliente;

    public Cuenta() {
    }

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

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
