package com.viridian.dummybank.controller;

import com.viridian.dummybank.model.Beneficiario;
import com.viridian.dummybank.service.BeneficiarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/beneficiario")
public class BeneficiarioController {

    @Autowired
    protected BeneficiarioService beneficiarioService;
    
    @RequestMapping(value = "/getAll",method = RequestMethod.GET)
    public List<Beneficiario> getAll(){
        return this.beneficiarioService.getAll();
    }

    @RequestMapping(value = "/saveOrUpdate", method = RequestMethod.POST)
    public void saveOrUpdate(@RequestBody Beneficiario beneficiario){
        this.beneficiarioService.save(beneficiario);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public List<Beneficiario> delete(@PathVariable Long id){
        this.beneficiarioService.delete(id);
        return this.beneficiarioService.getAll();
    }

    @RequestMapping(value = "/getBeneficiario/{id}", method = RequestMethod.GET)
    public Beneficiario getBeneficiario(@PathVariable Long id){
        return this.beneficiarioService.getBeneficiarioById(id);
    }
}
