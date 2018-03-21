package com.viridian.dummybank.rest.repository;

import com.viridian.dummybank.rest.model.PersonaJuridicaRestModel;
import com.viridian.dummybank.rest.model.PersonaRestModel;

public interface PersonaJuridicaMapper {

    PersonaJuridicaRestModel findPersonaJuridicaById(Long id);
}
