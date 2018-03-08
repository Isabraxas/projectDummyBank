package com.viridian.dummybank.rest;

import com.viridian.dummybank.dao.CuentaRepository;
import com.viridian.dummybank.error.NoEncontradoRestException;
import com.viridian.dummybank.model.Cliente;
import com.viridian.dummybank.model.persona.Persona;
import com.viridian.dummybank.model.persona.PersonaNatural;
import com.viridian.dummybank.rest.model.ProductoBancarioCliente;
import com.viridian.dummybank.rest.request.ClienteRequest;
import com.viridian.dummybank.rest.service.ClienteRestService;
import com.viridian.dummybank.service.ClienteService;
import com.viridian.dummybank.service.persona.PersonaJuridicaService;
import com.viridian.dummybank.service.persona.PersonaNaturalService;
import com.viridian.dummybank.service.persona.PersonaService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static org.mockito.Matchers.*;
import static org.mockito.Mockito.times;

import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class ClienteRestControllerTest2 {

    @Mock
    ClienteRestService clienteRestService;


    ClienteRestController clienteRestController;
    MockMvc mockMvc;

    @Before
    public void setUp() throws Exception{
        MockitoAnnotations.initMocks(this);

        clienteRestController = new ClienteRestController(clienteRestService);
        mockMvc = MockMvcBuilders.standaloneSetup(clienteRestController).build();
    }

    @Test
    public void getClienteTest() throws Exception{
        // given
        ProductoBancarioCliente prod = new ProductoBancarioCliente();
        prod.setIdCliente(1L);

        // when
        when(clienteRestService.getClienteByClienteId(1L)).thenReturn(prod);
        // then
        mockMvc.perform(get("/cliente/rest/show/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8));

        verify(clienteRestService, times(1)).getClienteByClienteId(anyLong());
    }

     @Test
    public void clienteNotFoundTest() throws Exception{
        when(clienteRestService.getClienteByClienteId(20l)).thenThrow(NoEncontradoRestException.class);

        mockMvc.perform(get("/cliente/rest/show/20"))
                .andExpect(status().isNotFound());
    }
}