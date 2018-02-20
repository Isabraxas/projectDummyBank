package com.viridian.dummybank.model;

import javax.persistence.*;
import java.io.Serializable;

@Table(name="Autorizacion")
@Entity
@Access(AccessType.FIELD)
public class Autorizacion implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_autorizacion", nullable = false)
    private Long idAutorizacion;
    @Column(name = "tipo", nullable = false, length = 255)
    private String tipo;
    @Column(name = "detalle", nullable = false, length = 255)
    private String detalle;

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
}
