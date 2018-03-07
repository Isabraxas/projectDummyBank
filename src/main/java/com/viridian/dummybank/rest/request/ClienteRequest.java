package com.viridian.dummybank.rest.request;

/**
 * Created by marcelo on 07-03-18
 */
public class ClienteRequest {
    private Long idCliente;

    public ClienteRequest() {
    }

    public ClienteRequest(Long idCliente) {
        this.idCliente = idCliente;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }
}
