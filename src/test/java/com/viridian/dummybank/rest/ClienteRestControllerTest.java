package com.viridian.dummybank.rest;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.viridian.dummybank.model.Cliente;
import com.viridian.dummybank.model.Cuenta;
import com.viridian.dummybank.repository.ClienteRepository;
import com.viridian.dummybank.rest.model.ProductoBancarioClientePN;
import com.viridian.dummybank.service.ClienteService;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(value=ClienteRestController.class,secure = false)
public class ClienteRestControllerTest {

    private MockMvc mockMvc;

    @MockBean
    private ClienteRestController clienteRestController;

/*
    @InjectMocks
    private ClienteRestController clienteRestController;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(clienteRestController).build();
    }

    @Test
    public void testGetCliente() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("cliente/rest/show/6")
                        .accept(MediaType.APPLICATION_JSON))
                        .andExpect(status().isOk())
                        .andExpect(jsonPath("$*"), Matchers.hasSize(1))
                        .andExpect(jsonPath("$.idCliente"), Matchers.is(6L))
                        .andExpect(jsonPath("$.estado"),Matchers.is("saccessful"))
                        .andExpect(jsonPath("$.idPersona"),Matchers.is(4L))
                        .andExpect(jsonPath("$.apellidoPaterno"),Matchers.is("aaaa"))
                        .andExpect(jsonPath("$.apellidoMaterno"),Matchers.is("bbbb"))
                        .andExpect(jsonPath("$.apellidoCasado"),Matchers.is("cccc"))
                        .andExpect(jsonPath("$.nombres"),Matchers.is("dddd"))
                        .andExpect(jsonPath("$.documentoIdentidad"),Matchers.is("eee"))
                        .andExpect(jsonPath("$.numeroDocumento"),Matchers.is(123456))
                        .andExpect(jsonPath("$.fechaNacimiento"),Matchers.is("2000-06-06"))
                        .andExpect(jsonPath("$.lugarNacimiento"),Matchers.is("fff"))
                        .andExpect(jsonPath("$.nacionalidad"),Matchers.is("ggg"))
                        .andExpect(jsonPath("$.domicilio"),Matchers.is("hhh"))
                        .andExpect(jsonPath("$.domicilioTrabajo"),Matchers.is("iii"))
                        .andExpect(jsonPath("$.telefono"),Matchers.is("jjj"))
                        .andExpect(jsonPath("$.email"),Matchers.is("kkk"))
                        .andExpect(jsonPath("$.estadoCivil"),Matchers.is("lll"))
                        .andExpect(jsonPath("$.profesion"),Matchers.is("mmm"))
                        .andExpect(jsonPath("$.caracterLegal"),Matchers.is("nnn"))
                        .andExpect(jsonPath("$.nombrePadre"),Matchers.is("ooo"))
                        .andExpect(jsonPath("$.nombreMadre"),Matchers.is("ppp"))
                        .andExpect(jsonPath("$.nombreConyuge"),Matchers.is("qqq"))
                        .andExpect(jsonPath("$.cuenta"),hasSize(3))
                        .andExpect(jsonPath("$.cuenta[*].idCuenta"), containsInAnyOrder("101","102","106"))
                        .andExpect(jsonPath("$.cuenta[*].numeroCuenta"), containsInAnyOrder("100004542","100004543","100004545"))
                        .andExpect(jsonPath("$.cuenta[*].idCuenta"), containsInAnyOrder("deposito","ahorro","prestamo"))
                        .andExpect(jsonPath("$.cuenta[*].idCuenta"), containsInAnyOrder("700","50","0"));
    }*/

    @Test
    public void testGetCliente() throws Exception {
        ProductoBancarioClientePN mockProductoBancarioCliente = new ProductoBancarioClientePN();

        mockProductoBancarioCliente.setIdCliente(6L);
        mockProductoBancarioCliente.setEstado("successful");
        mockProductoBancarioCliente.setIdPersona (4L);
        mockProductoBancarioCliente.setApellidoPaterno ("aaaa");
        mockProductoBancarioCliente.setApellidoMaterno ("bbbb");
        mockProductoBancarioCliente.setApellidoCasado ("ccc");
        mockProductoBancarioCliente.setNombres ("ddd");
        mockProductoBancarioCliente.setDocumentoIdentidad ("eee");
        mockProductoBancarioCliente.setNumeroDocumento (123456L);
        mockProductoBancarioCliente.setFechaNacimiento (java.sql.Date.valueOf("2000-06-06"));
        mockProductoBancarioCliente.setLugarNacimiento ("fff");
        mockProductoBancarioCliente.setNacionalidad ("ggg");
        mockProductoBancarioCliente.setDomicilio ("hhh");
        mockProductoBancarioCliente.setDomicilioTrabajo ("iii");
        mockProductoBancarioCliente.setTelefono ("jjj");
        mockProductoBancarioCliente.setEmail ("kkk");
        mockProductoBancarioCliente.setEstadoCivil ("lll");
        mockProductoBancarioCliente.setProfesion ("mmm");
        mockProductoBancarioCliente.setCaracterLegal ("nnn");
        mockProductoBancarioCliente.setNombrePadre ("ooo");
        mockProductoBancarioCliente.setNombreMadre ("ppp");
        mockProductoBancarioCliente.setNombreConyuge ("qqq");

        List<Cuenta> cuentas = new ArrayList<>();
        Cuenta cuenta1= new Cuenta();
        cuenta1.setIdCuenta(102L);
        cuenta1.setNumeroCuenta(100004542L);
        cuenta1.setTipo("deposito");
        cuenta1.setSaldo(BigDecimal.valueOf(700));

        Cuenta cuenta2= new Cuenta();
        cuenta2.setIdCuenta(103L);
        cuenta2.setNumeroCuenta(100004543L);
        cuenta2.setTipo("ahorro");
        cuenta2.setSaldo(BigDecimal.valueOf(50));

        Cuenta cuenta3= new Cuenta();
        cuenta3.setIdCuenta(106L);
        cuenta3.setNumeroCuenta(100004545L);
        cuenta3.setTipo("prestamo");
        cuenta3.setSaldo(BigDecimal.valueOf(0));

        cuentas.add(cuenta1);
        cuentas.add(cuenta2);
        cuentas.add(cuenta3);
        mockProductoBancarioCliente.setCuentas(cuentas);

        //Mockito.when(clienteRestController.getCliente(Mockito.anyString())).thenReturn(mockProductoBancarioCliente);

        String URI = "/cliente/rest/show/6";
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                URI).accept(
                MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        String expectedJson = this.mapToJson(mockProductoBancarioCliente);
        String outputInJson = result.getResponse().getContentAsString();
        assertThat(outputInJson).isEqualTo(expectedJson);
    }


    /**
     * Utiliza Jackson ObjectMapper.
     */
    private String mapToJson(Object mockProductoBancarioClienteect) throws JsonProcessingException {
        ObjectMapper mockProductoBancarioClienteectMapper = new ObjectMapper();
        return mockProductoBancarioClienteectMapper.writeValueAsString(mockProductoBancarioClienteect);
    }

}