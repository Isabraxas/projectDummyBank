package com.viridian.dummybank.rest;

import com.viridian.dummybank.error.NoEncontradoRestException;
import com.viridian.dummybank.model.Transaccion;
import com.viridian.dummybank.rest.model.MovimientoCliente;
import com.viridian.dummybank.rest.model.MovimientoClienteError;
import com.viridian.dummybank.rest.request.MovimientoRequest;
import com.viridian.dummybank.rest.service.MovimientoRestService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public List<MovimientoCliente> getMovimientoByCuenta(@PathVariable Long numeroCuenta){

        return this.movimientoRestService.getMovimientoByCuenta(numeroCuenta);
    }

    @GetMapping(value = "/getMovimientoByCuentaAndRangoFecha/{numeroCuenta}/{fechaDesde}/{fechaHasta}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<MovimientoCliente> getMovimientoByRangoFecha(@PathVariable Long numeroCuenta, @PathVariable String fechaDesde, @PathVariable String fechaHasta ){
        fechaHasta = fechaHasta+".0";
        return this.movimientoRestService.getMovimientoByRangoFecha(numeroCuenta,fechaDesde ,fechaHasta);
    }

    @GetMapping(value = "/getMovimientoByCuentaAndUltimos/{numeroCuenta}/{numeroMovimientos}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<MovimientoCliente> getMovimientoByCuentaAndUltimos(@PathVariable Long numeroCuenta, @PathVariable int numeroMovimientos){
        return this.movimientoRestService.getMovimientoByCuentaAndUltimos(numeroCuenta,numeroMovimientos);
    }

    @PostMapping(value = "/getMovimientos", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<MovimientoCliente> getMovimientos(@RequestBody MovimientoRequest movimientoRequest){

        return this.movimientoRestService.getMovimientos(movimientoRequest);
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoEncontradoRestException.class)
    public MovimientoClienteError handleNotFound(NoEncontradoRestException exception){
        MovimientoClienteError movimientoClienteError = new MovimientoClienteError();
        movimientoClienteError.setNumeroCuenta(exception.getErrorNoEncontrado().getId());
        movimientoClienteError.setEstado("error");
        movimientoClienteError.setError(exception.getErrorNoEncontrado());

        return movimientoClienteError;
    }

}
