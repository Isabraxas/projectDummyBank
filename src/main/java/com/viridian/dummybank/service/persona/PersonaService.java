package com.viridian.dummybank.service.persona;

import com.viridian.dummybank.model.persona.Persona;

import java.util.List;

/**
 * Created by marcelo on 22-02-18
 */
public interface PersonaService {

    List<Persona> getAllPersonas();

    Persona findPersonaById(Long id);

    void saveOrUpdatePersona(Persona persona);

    void deletePersona(Long id);
}
