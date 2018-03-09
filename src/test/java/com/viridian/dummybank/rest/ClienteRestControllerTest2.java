package com.viridian.dummybank.rest;

import com.viridian.dummybank.error.NoEncontradoRestException;
import com.viridian.dummybank.rest.model.ProductoBancarioClientePN;
import com.viridian.dummybank.rest.model.ProductoBancarioClientePJ;
import com.viridian.dummybank.rest.service.ClienteRestService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.is;
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
    public void getClienteNaturalTest() throws Exception{
        // given
        ProductoBancarioClientePN prod = new ProductoBancarioClientePN();
        prod.setIdCliente(1L);
        prod.setEstado("successful");

        // when
        when(clienteRestService.getClienteByClienteId(1L)).thenReturn(prod);
        // then
        mockMvc.perform(get("/cliente/N/rest/show/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.idCliente",is(1)))
                .andExpect(jsonPath("$.estado",is("successful")));

        verify(clienteRestService, times(1)).getClienteByClienteId(anyLong());
    }

    @Test
    public void getClienteJuridicoTest() throws Exception{
        // given
        ProductoBancarioClientePJ prod = new ProductoBancarioClientePJ();
        prod.setIdCliente(1L);
        prod.setEstado("successful");

        // when
        when(clienteRestService.getClienteJuridicoByClienteId(1L)).thenReturn(prod);
        // then
        mockMvc.perform(get("/cliente/J/rest/show/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.idCliente",is(1)))
                .andExpect(jsonPath("$.estado",is("successful")));

        verify(clienteRestService, times(1)).getClienteJuridicoByClienteId(anyLong());
    }

     @Test
    public void clienteNaturalNotFoundTest() throws Exception{
        when(clienteRestService.getClienteByClienteId(20l)).thenThrow(NoEncontradoRestException.class);

        mockMvc.perform(get("/cliente/rest/show/20"))
                .andExpect(status().isNotFound());
    }

    @Test
    public void clienteJuridicoNotFoundTest() throws Exception{
        when(clienteRestService.getClienteJuridicoByClienteId(20l)).thenThrow(NoEncontradoRestException.class);

        mockMvc.perform(get("/cliente/J/rest/show/20"))
                .andExpect(status().isNotFound());
    }
}