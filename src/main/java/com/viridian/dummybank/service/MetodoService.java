package com.viridian.dummybank.service;

import com.viridian.dummybank.model.Metodo;

import java.util.List;

public interface MetodoService {
    /**
     * Devuelve todas las metodoes
     * @return
     */
    List<Metodo> getAll();

    /**
     * Crea o actualiza un metodo con el cuerpo del parametro provisto
     * @param metodo
     */
    void save(Metodo metodo);

    /**
     * Elimina un metodo que coincida con el id provisto
     * @param id
     */
    void delete(Long id);

    /**
     * Encuentra un metodo que coincida con el id provisto
     * @param id
     * @return Metodo
     */
    Metodo getMetodoById(Long id);
}
