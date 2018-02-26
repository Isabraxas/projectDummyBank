package com.viridian.dummybank.service;

import com.viridian.dummybank.model.Operacion;

import java.util.List;

public interface OperacionService {
    /**
     * Devuelve todas las operaciones
     * @return
     */
    List<Operacion> getAll();

    /**
     * Crea o actualiza un operacion con el cuerpo del parametro provisto
     * @param operacion
     */
    void save(Operacion operacion);

    /**
     * Elimina un operacion que coincida con el id provisto
     * @param id
     */
    void delete(Long id);

    /**
     * Encuentra un operacion que coincida con el id provisto
     * @param id
     * @return Operacion
     */
    Operacion getOperacionById(Long id);

}
