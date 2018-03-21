package com.viridian.dummybank.rest.model;

public class PersonaJuridicaRestModel {
    private Long idCliente;
    private String nombreRazon;
    private Long nit;
    private String registroFundaempresa;
    private Long representanteLegal;

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
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

    public String getRegistroFundaempresa() {
        return registroFundaempresa;
    }

    public void setRegistroFundaempresa(String registroFundaempresa) {
        this.registroFundaempresa = registroFundaempresa;
    }

    public Long getRepresentanteLegal() {
        return representanteLegal;
    }

    public void setRepresentanteLegal(Long representanteLegal) {
        this.representanteLegal = representanteLegal;
    }
}
