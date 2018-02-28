package com.viridian.dummybank.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Table(name="Estatus")
@Entity
@Access(AccessType.FIELD)
public class Estatus implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_estatus", nullable = false)
    private Long idEstatus;

    private String descripcion;

    @OneToMany(mappedBy = "estatus")
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
