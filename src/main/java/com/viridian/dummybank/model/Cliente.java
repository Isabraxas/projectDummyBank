package com.viridian.dummybank.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

/**
 * Created by marcelo on 20-02-18
 */
@Entity
@Table(name = "Cliente")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private Long id;

    private String tipo;    // para diferenciar a que tabla buscar subsecuente (J juridica, N natural)

    @OneToMany(mappedBy = "cliente")    // private Cliente cliente, de la clase Cuenta, es quien es "dueño" de este campo(posee las clavs foraneas)
    private List<Cuenta> cuentas;


    @ManyToMany
    @JoinTable(
            name = "Cliente_Beneficiario",
            joinColumns = @JoinColumn(name="cliente_id"),
            inverseJoinColumns =  @JoinColumn(name="beneficiario_id"))
    private List<Beneficiario> beneficiarios;

    @OneToMany(mappedBy = "cliente")
    @JsonBackReference
    private List<Transaccion> transaccions;

    public Cliente() {
    }

    public Cliente(List<Cuenta> cuentas, String tipo) {
        this.cuentas = cuentas;
        this.tipo = tipo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Cuenta> getCuentas() {
        return cuentas;
    }

    public void setCuentas(List<Cuenta> cuentas) {
        this.cuentas = cuentas;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public List<Beneficiario> getBeneficiarios() {
        return beneficiarios;
    }

    public void setBeneficiarios(List<Beneficiario> beneficiarios) {
        this.beneficiarios = beneficiarios;
    }

    public List<Transaccion> getTransaccions() {
        return transaccions;
    }

    public void setTransaccions(List<Transaccion> transaccions) {
        this.transaccions = transaccions;
    }
}
