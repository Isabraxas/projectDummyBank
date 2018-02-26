package com.viridian.dummybank.service.persona;

import com.viridian.dummybank.model.persona.PersonaNatural;

import java.util.List;

/**
 * Created by marcelo on 22-02-18
 */
public interface PersonaNaturalService {

    List<PersonaNatural> findAllPersonasNaturales();

    PersonaNatural findOneById(Long id);

    void saveOrUpdatePersonaNatural(PersonaNatural personaNatural);

    void deletePersonaNatural(Long id);
}
