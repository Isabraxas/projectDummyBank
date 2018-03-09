package com.viridian.dummybank.rest;

import com.viridian.dummybank.error.NoEncontradoRestException;
import com.viridian.dummybank.model.persona.Persona;
import com.viridian.dummybank.service.persona.PersonaService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.when;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.times;

import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by marcelo on 09-03-18
 */
public class PersonaRestControllerTest {

    @Mock
    PersonaService personaService;

    PersonaRestController personaRestController;
    MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        personaRestController = new PersonaRestController(personaService);
        mockMvc = MockMvcBuilders.standaloneSetup(personaRestController).build();
    }

    @Test
    public void getPersona() throws Exception{
        // given
        Persona persona = new Persona();
        persona.setId(1L);
        // when
        when(personaService.findPersonaById(1L)).thenReturn(persona);
        // then
        mockMvc.perform(get("/persona/rest/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.id", is(1)));

        verify(personaService, times(1)).findPersonaById(anyLong());
    }

    @Test
    public void handleNotFound() throws Exception{
        when(personaService.findPersonaById(20l)).thenThrow(NoEncontradoRestException.class);

        mockMvc.perform(get("/persona/rest/"))
                .andExpect(status().isNotFound());
    }
}