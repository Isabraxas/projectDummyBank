package com.viridian.dummybank.service.persona;

import com.viridian.dummybank.model.persona.PersonaJuridica;

import java.util.List;

/**
 * Created by marcelo on 22-02-18
 */
public interface PersonaJuridicaService {

    List<PersonaJuridica> findAllPersonaJuridica();

    PersonaJuridica findOneById(Long id);

    void saveOrUpdatePersonaJuridica(PersonaJuridica cliente);

    void deletePersonaJuridica(Long id);
}
