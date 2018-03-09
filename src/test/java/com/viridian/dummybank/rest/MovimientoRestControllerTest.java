package com.viridian.dummybank.rest;

import com.viridian.dummybank.error.NoEncontradoRestException;
import com.viridian.dummybank.rest.model.ProductoBancarioClientePJ;
import com.viridian.dummybank.rest.model.ProductoBancarioClientePN;
import com.viridian.dummybank.rest.service.MovimientoRestService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.is;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class MovimientoRestControllerTest {

    @Mock
    MovimientoRestService movimientoRestService;


    MovimientoRestController movimientoRestController;
    MockMvc mockMvc;

    @Before
    public void setUp() throws Exception{
        MockitoAnnotations.initMocks(this);

        movimientoRestController = new MovimientoRestController(movimientoRestService);
        mockMvc = MockMvcBuilders.standaloneSetup(movimientoRestController).build();
    }

    @Test
    public void getClienteTest() throws Exception{
        // given
        ProductoBancarioClientePN prod = new ProductoBancarioClientePN();
        prod.setIdCliente(1L);
        prod.setEstado("successful");

        // when
        when(movimientoRestService.getClienteByClienteId(1L)).thenReturn(prod);
        // then
        mockMvc.perform(get("/cliente/N/rest/show/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.idCliente",is(1)))
                .andExpect(jsonPath("$.estado",is("successful")));

        verify(movimientoRestService, times(1)).getClienteByClienteId(anyLong());
    }


     @Test
    public void clienteNotFoundTest() throws Exception{
        when(movimientoRestService.getClienteByClienteId(20l)).thenThrow(NoEncontradoRestException.class);

        mockMvc.perform(get("/cliente/rest/show/20"))
                .andExpect(status().isNotFound());
    }

}