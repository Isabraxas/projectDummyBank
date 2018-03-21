package com.viridian.dummybank.rest;


import com.viridian.dummybank.error.NoEncontradoRestException;
import com.viridian.dummybank.rest.error.CuentaRestError;
import com.viridian.dummybank.rest.model.CuentaRestModel;
import com.viridian.dummybank.rest.model.ProductoBancarioClienteError;
import com.viridian.dummybank.rest.repository.CuentaMapper;
import com.viridian.dummybank.rest.service.CuentaRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/cuentas")
public class CuentaRestController {

    private final CuentaRestService cuentaRestService;

    @Autowired
    public CuentaRestController(CuentaRestService cuentaRestService) {
        this.cuentaRestService = cuentaRestService;
    }

    @GetMapping
    public List<CuentaRestModel> getAllCuenta(){
        return cuentaRestService.getAllCuentas();
    }
    @GetMapping("/{id}")
    public CuentaRestModel getCuenta(@PathVariable Long id){
        return cuentaRestService.getCuentaById(id);
    }
    @GetMapping("/{id}/cliente")
    public CuentaRestModel getCuentaWithCliente(@PathVariable Long id){
        return cuentaRestService.getCuentaWithCliente(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void createCuenta(@RequestBody CuentaRestModel cuenta){
        cuentaRestService.createCuenta(cuenta);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping
    public CuentaRestModel updateCuenta(@RequestBody CuentaRestModel cuenta){

           CuentaRestModel cuentaModificada = cuentaRestService.updateCuenta(cuenta);
            return cuentaModificada;
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping
    public void deleteCuenta(@RequestBody CuentaRestModel cuenta){
        cuentaRestService.deleteCuenta(cuenta);
    }



   /*


    @PostMapping("/id")
    public List<CuentaRestModel> getCuentaBySP(@RequestBody CuentaRestModel cuenta){
        return cuentaRepository.findCuentaByIdCuenta(cuenta);
    }



    @PostMapping
    public List<CuentaRestModel> createCuenta(@RequestBody CuentaRestModel cuenta){
        cuentaRepository.insertCuenta(cuenta);
        return cuentaRepository.findAllCuentas();
    }


    */

   //Excepciones
   @ResponseStatus(HttpStatus.NOT_FOUND)
   @ExceptionHandler(NoEncontradoRestException.class)
   public CuentaRestError handleNotFound(NoEncontradoRestException exception){
       CuentaRestError error = new CuentaRestError();
       error.setIdCuenta(exception.getErrorNoEncontrado().getId());
       error.setEstado("error");
       error.setError(exception.getErrorNoEncontrado());
       return error;
   }

}
