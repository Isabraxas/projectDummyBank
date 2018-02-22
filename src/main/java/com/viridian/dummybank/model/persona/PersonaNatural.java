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
    private Long Id;            // atributo directamente relacionado a Cliente en DB

    // todo persona


    public PersonaNatural() {
    }

    public PersonaNatural(Long id) {
        Id = id;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }
}
