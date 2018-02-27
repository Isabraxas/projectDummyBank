package com.viridian.dummybank.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by marcelo on 20-02-18
 */
@Entity
@Table(name = "Cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private Long id;

    @OneToMany(mappedBy = "cliente")    // private Cliente cliente, de la clase Cuenta, es quien es "dueño" de este campo(posee las clavs foraneas)
    private List<Cuenta> cuentas;

    private String tipo;    // para diferenciar a que tabla buscar subsecuente (J juridica, N natural)

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
}
