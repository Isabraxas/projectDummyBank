package com.viridian.dummybank.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Table(name="Estatus")
@Entity
@Access(AccessType.FIELD)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Estatus implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_estatus", nullable = false)
    private Long idEstatus;

    private String descripcion;

    @OneToMany(mappedBy = "estatus")
    @JsonBackReference
    private List<Transaccion> transaccions;

    public Long getIdEstatus() {
        return idEstatus;
    }

    public void setIdEstatus(Long idEstatus) {
        this.idEstatus = idEstatus;
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
