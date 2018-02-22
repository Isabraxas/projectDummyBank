package com.viridian.dummybank.controller;

import com.viridian.dummybank.model.Operacion;
import com.viridian.dummybank.service.OperacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/operacion")
public class OperacionController {
    
    @Autowired
    protected OperacionService operacionService;

    @RequestMapping(value = "/getAll",method = RequestMethod.GET)
    public List<Operacion> getAll(){
        return this.operacionService.getAll();
    }

    @RequestMapping(value = "/saveOrUpdate", method = RequestMethod.POST)
    public void saveOrUpdate(@RequestBody Operacion operacion){
        this.operacionService.save(operacion);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public List<Operacion> delete(@PathVariable Long id){
        this.operacionService.delete(id);
        return this.operacionService.getAll();
    }

    @RequestMapping(value = "/getOperacion/{id}", method = RequestMethod.GET)
    public Operacion getOperacion(@PathVariable Long id){
        return this.operacionService.getOperacionById(id);
    }

}
