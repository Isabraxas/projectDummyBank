package com.viridian.dummybank.rest.repository;

import com.viridian.dummybank.rest.model.PersonaNaturalRestModel;

public interface PersonaNaturalMapper {

    PersonaNaturalRestModel findPersonaNaturalById(Long id);
}
