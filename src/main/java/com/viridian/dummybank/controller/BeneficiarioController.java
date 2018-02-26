package com.viridian.dummybank.controller;

import com.viridian.dummybank.model.Beneficiario;
import com.viridian.dummybank.service.BeneficiarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/beneficiario")
public class BeneficiarioController {

    @Autowired
    protected BeneficiarioService beneficiarioService;
   

    @GetMapping(value = "/getAll")
    public  String getAll(Model model){
        model.addAttribute("beneficiarios", this.beneficiarioService.getAll());
        return "beneficiario/beneficiario-all";
    }

    @GetMapping(value = "/getBeneficiario/{id}")
    public String getBeneficiario(Model model, @PathVariable Long id){
        model.addAttribute("beneficiario",this.beneficiarioService.getBeneficiarioById(id));
        return "beneficiario/beneficiario-show";
    }

    @GetMapping("/new")
    public String newBeneficiario(Model model){
        model.addAttribute("beneficiario", new Beneficiario());
        model.addAttribute("accion", "guardar");
        return "beneficiario/beneficiario-form";
    }
    @PostMapping("/save")
    public String saveBeneficiario(Beneficiario beneficiario){
        beneficiarioService.save(beneficiario);
        return "redirect:/beneficiario/getAll";
    }
    @GetMapping("/update/{id}")
    public String updateBeneficiario(@PathVariable Long id, Model model){
        Beneficiario beneficiario = beneficiarioService.getBeneficiarioById(id);
        model.addAttribute("beneficiario", beneficiario);
        model.addAttribute("accion", "actualizar");
        return "beneficiario/beneficiario-form";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        this.beneficiarioService.delete(id);
        return "redirect:/beneficiario/getAll";
    }

    
    
    @RequestMapping(value = "/saveOrUpdate", method = RequestMethod.POST)
    public void saveOrUpdate(@RequestBody Beneficiario beneficiario){
        this.beneficiarioService.save(beneficiario);
    }

 /*
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public List<Beneficiario> delete(@PathVariable Long id){
        this.beneficiarioService.delete(id);
        return this.beneficiarioService.getAll();
    }
    
    @RequestMapping(value = "/getAll",method = RequestMethod.GET)
    public List<Beneficiario> getAll(){
        return this.beneficiarioService.getAll();
    }*/
     
     
   /* @RequestMapping(value = "/getBeneficiario/{id}", method = RequestMethod.GET)
    public Beneficiario getBeneficiario(@PathVariable Long id){
        return this.beneficiarioService.getBeneficiarioById(id);
    }
    */
}
