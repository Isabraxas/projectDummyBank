package com.viridian.dummybank.service;

import com.viridian.dummybank.model.Autorizacion;

import java.util.List;

public interface AutorizacionService {
    /**
     * Devuelve todas las autorizaciones
     * @return
     */
    List<Autorizacion> getAll();

    /**
     * Crea o actualiza una autorizacion con el cuerpo del parametro provisto
     * @param autorizacion
     */
    void save(Autorizacion autorizacion);

    /**
     * Elimina una autorizacion que coincida con el id provisto
     * @param id
     */
    void delete(Long id);

    /**
     * Encuentra una autorizacion que coincida con el id provisto
     * @param id
     * @return Autorizacion
     */
    Autorizacion getAutorizacionById(Long id);
}
