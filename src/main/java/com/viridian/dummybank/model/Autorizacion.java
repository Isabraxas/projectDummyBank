package com.viridian.dummybank.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Table(name="Autorizacion")
@Entity
@Access(AccessType.FIELD)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Autorizacion implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_autorizacion", nullable = false)
    private Long idAutorizacion;
    @Column(name = "tipo", nullable = false, length = 255)
    private String tipo;
    @Column(name = "detalle", nullable = false, length = 255)
    private String detalle;

    @OneToMany(mappedBy = "autorizacion")
    @JsonBackReference
    private List<Transaccion> transaccions;

    public Autorizacion(){}

    public Autorizacion(String tipo, String detalle) {
        this.tipo = tipo;
        this.detalle = detalle;
    }

    public Long getIdAutorizacion() {
        return idAutorizacion;
    }

    public void setIdAutorizacion(Long idAutorizacion) {
        this.idAutorizacion = idAutorizacion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public List<Transaccion> getTransaccions() {
        return transaccions;
    }

    public void setTransaccions(List<Transaccion> transaccions) {
        this.transaccions = transaccions;
    }
}
