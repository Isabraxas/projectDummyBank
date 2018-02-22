package com.viridian.dummybank.model.persona;

import javax.persistence.*;

/**
 * Created by marcelo on 22-02-18
 */
@Entity
@Table(name = "Persona_Juridica")
public class PersonaJuridica {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private Long Id;

    @Column(name = "nombre_razon")
    private String nombreRazon;
    @Column(name = "nit")
    private Long nit;
    @Column(name = "registro_fundaempresa")
    private String registroFundaemesa;

    // todo persona (representante legal)


    public PersonaJuridica() {
    }

    public PersonaJuridica(Long id, String nombreRazon, Long nit, String registroFundaemesa) {
        Id = id;
        this.nombreRazon = nombreRazon;
        this.nit = nit;
        this.registroFundaemesa = registroFundaemesa;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getNombreRazon() {
        return nombreRazon;
    }

    public void setNombreRazon(String nombreRazon) {
        this.nombreRazon = nombreRazon;
    }

    public Long getNit() {
        return nit;
    }

    public void setNit(Long nit) {
        this.nit = nit;
    }

    public String getRegistroFundaemesa() {
        return registroFundaemesa;
    }

    public void setRegistroFundaemesa(String registroFundaemesa) {
        this.registroFundaemesa = registroFundaemesa;
    }
}
