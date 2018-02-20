package com.viridian.dummybank.controller;

import com.viridian.dummybank.model.Estatus;
import com.viridian.dummybank.service.EstatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping(value = "/estatus")
public class EstatusController {
    @Autowired
    protected EstatusService estatusService;

    @RequestMapping(value = "/getAll",method = RequestMethod.GET)
    public List<Estatus> getAll(){
        return this.estatusService.getAll();
    }

    @RequestMapping(value = "/saveOrUpdate", method = RequestMethod.POST)
    public void saveOrUpdate(@RequestBody Estatus estatus){
        this.estatusService.save(estatus);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public List<Estatus> delete(@PathVariable Long id){
        this.estatusService.delete(id);
        return this.estatusService.getAll();
    }

    @RequestMapping(value = "/getEstatus/{id}", method = RequestMethod.GET)
    public Estatus getEstatus(@PathVariable Long id){
        return this.estatusService.getEstatusById(id);
    }
}
