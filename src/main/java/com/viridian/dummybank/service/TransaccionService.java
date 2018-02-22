package com.viridian.dummybank.service;

import com.viridian.dummybank.model.Transaccion;

import java.util.List;

public interface TransaccionService {
    /**
     * Devuelve todas las transacciones
     * @return
     */
    List<Transaccion> getAll();

    /**
     * Crea o actualiza un transaccion con el cuerpo del parametro provisto
     * @param transaccion
     */
    void save(Transaccion transaccion);

    /**
     * Elimina un transaccion que coincida con el id provisto
     * @param id
     */
    void delete(Long id);

    /**
     * Encuentra un transaccion que coincida con el id provisto
     * @param id
     * @return Transaccion
     */
    Transaccion getTransaccionById(Long id);
}
