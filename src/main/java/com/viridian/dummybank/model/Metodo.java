package com.viridian.dummybank.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Metodo")
@Access(AccessType.FIELD)
public class Metodo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_metodo", nullable = false)
    private Long idMetodo;

    @Column(name= "descripcion", nullable = false)
    private String descripcion;

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
}
