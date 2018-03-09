package com.viridian.dummybank.rest;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.response.ValidatableResponse;
import com.viridian.dummybank.DummybankApplication;
import com.viridian.dummybank.error.ErrorNoEncontrado;
import com.viridian.dummybank.model.Cuenta;
import com.viridian.dummybank.rest.model.ProductoBancarioClientePN;
import com.viridian.dummybank.rest.model.ProductoBancarioClienteError;
import org.apache.http.HttpStatus;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static com.jayway.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DummybankApplication.class , webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

public class ClienteRestControllerIT {
    // logger
    private static final Logger log = org.slf4j.LoggerFactory.getLogger(ClienteRestControllerIT.class);

    @Value("${local.server.port}")
    private int serverPort;

    @Before
    public void setUp() {
        RestAssured.port = serverPort;
    }

    @Test
    public void testGetCienteById() throws JsonProcessingException {
        ValidatableResponse response =given()
                .accept(ContentType.JSON)
                .pathParam("id","6")
                .when()
                .get("/cliente/rest/show/{id}")
                .then()
                .statusCode(HttpStatus.SC_OK);

        JsonPath jp = new JsonPath(response.extract().asString());
        String outputInJson = response.extract().asString();
        log.info("Response: "+response.extract().asString());
        ProductoBancarioClientePN productoBancarioCliente =this.createMockPBC();
        String expectedJson = this.mapToJson(productoBancarioCliente);
        log.info("ExpectedJson: "+expectedJson);
        assertThat(outputInJson).isEqualTo(expectedJson);
    }

    @Test
    public void testClienteNotFound() throws JsonProcessingException {
        //given
        ProductoBancarioClienteError productoBancarioClienteError = this.createMockPBCE();
        //When
        ValidatableResponse response =given()
                .accept(ContentType.JSON)
                .pathParam("id","20")
                .when()
                .get("/cliente/rest/show/{id}")
              //Then
                .then()
                .statusCode(HttpStatus.SC_NOT_FOUND);
        //Verify
        String outputInJson = response.extract().asString();
        log.info("Response: "+ outputInJson);
        String expectedJson = this.mapToJson(productoBancarioClienteError);
        log.info("ExpectedJson: "+expectedJson);
        assertThat(outputInJson).isEqualTo(expectedJson);

    }

    private ProductoBancarioClienteError createMockPBCE(){
        ProductoBancarioClienteError mockProductoBancarioClienteError = new ProductoBancarioClienteError();
        mockProductoBancarioClienteError.setIdCliente(20L);
        mockProductoBancarioClienteError.setEstado("error");
        ErrorNoEncontrado errorNoEncontrado = new ErrorNoEncontrado(
                20L,"001","no se encontro al Cliente en la BD","Hemos encontrado un error intentelo mas tarde");
        mockProductoBancarioClienteError.setError(errorNoEncontrado);

        return mockProductoBancarioClienteError;
    }

    private ProductoBancarioClientePN createMockPBC(){

        ProductoBancarioClientePN mockProductoBancarioCliente = new ProductoBancarioClientePN();

        mockProductoBancarioCliente.setIdCliente(6L);
        mockProductoBancarioCliente.setEstado("successful");
        mockProductoBancarioCliente.setIdPersona (4L);
        mockProductoBancarioCliente.setApellidoPaterno ("aaaa");
        mockProductoBancarioCliente.setApellidoMaterno ("bbbb");
        mockProductoBancarioCliente.setApellidoCasado ("ccc");
        mockProductoBancarioCliente.setNombres ("ddd");
        mockProductoBancarioCliente.setDocumentoIdentidad ("eee");
        mockProductoBancarioCliente.setNumeroDocumento (132456L);
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

        return mockProductoBancarioCliente;
    }


    /**
     * Utiliza Jackson ObjectMapper.
     */
    private String mapToJson(Object mockProductoBancarioClienteect) throws JsonProcessingException {
        ObjectMapper mockProductoBancarioClienteectMapper = new ObjectMapper();
        return mockProductoBancarioClienteectMapper.writeValueAsString(mockProductoBancarioClienteect);
    }
}
