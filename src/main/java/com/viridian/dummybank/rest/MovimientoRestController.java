package com.viridian.dummybank.rest;

import com.viridian.dummybank.model.Transaccion;
import com.viridian.dummybank.rest.service.MovimientoRestService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovimientoRestController {
    //Logger
    private static final Logger log = org.slf4j.LoggerFactory.getLogger(MovimientoRestController.class);

    //Servicio
    private final MovimientoRestService movimientoRestService;

    @Autowired
    public MovimientoRestController(MovimientoRestService movimientoRestService) {
        this.movimientoRestService = movimientoRestService;
    }

    @GetMapping(value = "/getMovimientoByCuenta/{numeroCuenta}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Transaccion> getMovimientoByCuenta(@PathVariable Long numeroCuenta){

        return this.movimientoRestService.getMovimientoByCuenta(numeroCuenta);
    }
}
