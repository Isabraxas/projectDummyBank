package com.viridian.dummybank.service;

import com.viridian.dummybank.model.Estatus;

import java.util.List;

public interface EstatusService {
    /**
     * Devuelve todas las estatuses
     * @return
     */
    List<Estatus> getAll();

    /**
     * Crea o actualiza un estatus con el cuerpo del parametro provisto
     * @param estatus
     */
    void save(Estatus estatus);

    /**
     * Elimina un estatus que coincida con el id provisto
     * @param id
     */
    void delete(Long id);

    /**
     * Encuentra un estatus que coincida con el id provisto
     * @param id
     * @return Estatus
     */
    Estatus getEstatusById(Long id);
}
