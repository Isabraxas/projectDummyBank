package com.viridian.dummybank.rest.model;

public class PersonaNaturalRestModel {
    private Long idCliente;
    private Long personaId;
    private PersonaRestModel persona;

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public Long getPersonaId() {
        return personaId;
    }

    public void setPersonaId(Long personaId) {
        this.personaId = personaId;
    }

    public PersonaRestModel getPersona() {
        return persona;
    }

    public void setPersona(PersonaRestModel persona) {
        this.persona = persona;
    }
}
