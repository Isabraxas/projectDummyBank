package com.viridian.dummybank.rest.model;

import com.viridian.dummybank.error.EntidadError;
import com.viridian.dummybank.error.ErrorNoEncontrado;

/**
 * Created by marcelo on 09-03-18
 */
public class PersonaError extends EntidadError {

    public PersonaError() {
    }

    public PersonaError(Long id, String estado, ErrorNoEncontrado error) {
        super(id, estado, error);
    }
}
