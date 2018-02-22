package com.viridian.dummybank.service;

import com.viridian.dummybank.model.Operador;

import java.util.List;

public interface OperadorService {
    /**
     * Devuelve todas las operadores
     * @return
     */
    List<Operador> getAll();

    /**
     * Crea o actualiza un operador con el cuerpo del parametro provisto
     * @param operador
     */
    void save(Operador operador);

    /**
     * Elimina un operador que coincida con el id provisto
     * @param id
     */
    void delete(Long id);

    /**
     * Encuentra un operador que coincida con el id provisto
     * @param id
     * @return Operador
     */
    Operador getOperadorById(Long id);
}
