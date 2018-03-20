package com.viridian.dummybank.rest;


import com.viridian.dummybank.rest.model.CuentaRestModel;
import com.viridian.dummybank.rest.repository.CuentaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/cuentas")
public class CuentaRestController {

    private final CuentaMapper cuentaRepository;

    @Autowired
    public CuentaRestController(CuentaMapper cuentaRepository) {
        this.cuentaRepository = cuentaRepository;
    }
    @GetMapping
    public List<CuentaRestModel> getAllCuenta(){
        return cuentaRepository.findAllCuentas();
    }

    @GetMapping("/{id}")
    public CuentaRestModel getCuenta(@PathVariable Long id){
        return cuentaRepository.findCuentaById(id);
    }

    @PostMapping("/id")
    public List<CuentaRestModel> getCuentaBySP(@RequestBody CuentaRestModel cuenta){
        return cuentaRepository.findCuentaByIdCuenta(cuenta);
    }

    @GetMapping("/{id}/cliente")
    public CuentaRestModel getCuentaWithCliente(@PathVariable Long id){
        return cuentaRepository.findCuentaWithCliente(id);
    }

    @PutMapping
    public CuentaRestModel updateCuenta(@RequestBody CuentaRestModel cuenta){
        cuentaRepository.updateCuenta(cuenta);
        return cuentaRepository.findCuentaById(cuenta.getIdCuenta());
    }

    @PostMapping
    public List<CuentaRestModel> createCuenta(@RequestBody CuentaRestModel cuenta){
        cuentaRepository.insertCuenta(cuenta);
        return cuentaRepository.findAllCuentas();
    }

    @DeleteMapping
    public List<CuentaRestModel> deleteCuenta(@RequestBody CuentaRestModel cuenta){
        cuentaRepository.deleteCuenta(cuenta);
        return cuentaRepository.findAllCuentas();
    }

}
