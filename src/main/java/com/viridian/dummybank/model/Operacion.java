package com.viridian.dummybank.model;

import javax.persistence.*;
import java.io.Serializable;

@Table(name="Operacion")
@Entity
@Access(AccessType.FIELD)
public class Operacion implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_operacion", nullable = false)
    private Long idOperacion;

    @Column(name= "descripcion", nullable = false)
    private String descripcion;


    public Long getIdOperacion() {
        return idOperacion;
    }

    public void setIdOperacion(Long idOperacion) {
        this.idOperacion = idOperacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
