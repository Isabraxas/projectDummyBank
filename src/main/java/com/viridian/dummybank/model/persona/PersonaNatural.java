package com.viridian.dummybank.model.persona;

import javax.persistence.*;

/**
 * Created by marcelo on 22-02-18
 */
@Entity
@Table(name = "Persona_Natural")
public class PersonaNatural {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private Long id;            // atributo directamente relacionado a Cliente en DB

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="persona_id")      // id de la tabla a la que une,
    private Persona persona;


    public PersonaNatural() {
    }

    public PersonaNatural(Long id, Persona persona) {
        this.id = id;
        this.persona = persona;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
}
