package com.viridian.dummybank.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Metodo")
@Access(AccessType.FIELD)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Metodo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_metodo", nullable = false)
    private Long idMetodo;

    @Column(name= "descripcion", nullable = false)
    private String descripcion;

    @OneToMany(mappedBy = "metodo")
    @JsonBackReference
    private List<Transaccion> transaccions;

    public Long getIdMetodo() {
        return idMetodo;
    }

    public void setIdMetodo(Long idMetodo) {
        this.idMetodo = idMetodo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Transaccion> getTransaccions() {
        return transaccions;
    }

    public void setTransaccions(List<Transaccion> transaccions) {
        this.transaccions = transaccions;
    }
}
