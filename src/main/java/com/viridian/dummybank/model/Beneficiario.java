package com.viridian.dummybank.model;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Table(name="Beneficiario")
@Entity
@Access(AccessType.FIELD)
public class Beneficiario implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_beneficiario", nullable = false)
    private Long idBeneficiario;

    @Column(name = "nombre_rs", nullable = false)
    private String nombreRs;

    @Column(name = "nit_ci", nullable = false)
    private String nitCi;

    @Column(name = "numero_cuenta", nullable = false)
    private Long numeroCuenta;

    @Column(name = "monto", nullable = false)
    private BigDecimal monto ;

    @Column(name = "moneda", nullable = false)
    private String moneda;

    @Column(name = "banco", nullable = false)
    private String banco;

    @ManyToMany(mappedBy = "beneficiarios")
    private List<Cliente> clientes;

    public Long getIdBeneficiario() {
        return idBeneficiario;
    }

    public void setIdBeneficiario(Long idBeneficiario) {
        this.idBeneficiario = idBeneficiario;
    }

    public String getNombreRs() {
        return nombreRs;
    }

    public void setNombreRs(String nombreRs) {
        this.nombreRs = nombreRs;
    }

    public String getNitCi() {
        return nitCi;
    }

    public void setNitCi(String nitCi) {
        this.nitCi = nitCi;
    }

    public Long getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(Long numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
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

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }
}
