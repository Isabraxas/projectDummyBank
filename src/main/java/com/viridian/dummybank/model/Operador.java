package com.viridian.dummybank.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Table(name="Operador")
@Entity
@Access(AccessType.FIELD)
public class Operador implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_operador", nullable = false)
    private Long idOperador;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "usuario_id", nullable = false)
    private Long usuarioId;

    @OneToMany(mappedBy = "operador")
    private List<Transaccion> transaccions;



    public Long getIdOperador() {
        return idOperador;
    }

    public void setIdOperador(Long idOperador) {
        this.idOperador = idOperador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public List<Transaccion> getTransaccions() {
        return transaccions;
    }

    public void setTransaccions(List<Transaccion> transaccions) {
        this.transaccions = transaccions;
    }
}
