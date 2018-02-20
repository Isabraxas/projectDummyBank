package com.viridian.dummybank.model;

import javax.persistence.*;
import java.io.Serializable;

@Table(name="Estatus")
@Entity
@Access(AccessType.FIELD)
public class Estatus implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_estatus", nullable = false)
    private Long idEstatus;

    private String descripcion;

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
}
