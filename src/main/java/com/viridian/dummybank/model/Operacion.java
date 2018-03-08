package com.viridian.dummybank.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Table(name="Operacion")
@Entity
@Access(AccessType.FIELD)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Operacion implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_operacion", nullable = false)
    private Long idOperacion;

    @Column(name= "descripcion", nullable = false)
    private String descripcion;

    @OneToMany(mappedBy = "operacion")
    @JsonBackReference
    private List<Transaccion> transaccions;

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

    public List<Transaccion> getTransaccions() {
        return transaccions;
    }

    public void setTransaccions(List<Transaccion> transaccions) {
        this.transaccions = transaccions;
    }
}
