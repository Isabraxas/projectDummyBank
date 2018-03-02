package com.viridian.dummybank.service;

import com.viridian.dummybank.model.Beneficiario;

import java.util.List;

public interface BeneficiarioService {
    /**
     * Devuelve todas las beneficiarioes
     * @return
     */
    List<Beneficiario> getAll();

    /**
     * Crea o actualiza un beneficiario con el cuerpo del parametro provisto
     * @param beneficiario
     */
    void save(Beneficiario beneficiario);

    /**
     * Elimina un beneficiario que coincida con el id provisto
     * @param id
     */
    void delete(Long id);

    /**
     * Encuentra un beneficiario que coincida con el id provisto
     * @param id
     * @return Beneficiario
     */
    Beneficiario getBeneficiarioById(Long id);


    // añadido por marcelo
    Beneficiario getBeneficiarioByNumeroCuenta(Long numeroCuenta);
}
