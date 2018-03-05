package com.viridian.dummybank.controller;


import com.viridian.dummybank.model.Beneficiario;
import com.viridian.dummybank.model.Cliente;
import com.viridian.dummybank.model.Cuenta;
import com.viridian.dummybank.model.persona.PersonaJuridica;
import com.viridian.dummybank.model.persona.PersonaNatural;
import com.viridian.dummybank.service.BeneficiarioService;
import com.viridian.dummybank.service.CuentaService;
import com.viridian.dummybank.service.persona.PersonaJuridicaService;
import com.viridian.dummybank.service.persona.PersonaNaturalService;
import com.viridian.dummybank.service.persona.PersonaService;
import com.viridian.dummybank.utils.ClienteUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@Controller
@RequestMapping(value = "/cuenta")
public class CuentaController {
    
    @Autowired
    protected CuentaService cuentaService;
    @Autowired
    protected BeneficiarioService beneficiarioService;
    @Autowired
    protected PersonaNaturalService personaNaturalService;
    @Autowired
    protected PersonaJuridicaService personaJuridicaService;


    @GetMapping(value = "/getAll")
    public  String getAll(Model model){
        model.addAttribute("cuentas", this.cuentaService.getAll());
        return "cuenta/cuenta-all";
    }

    @GetMapping(value = "/getCuenta/{id}")
    public String getCuenta(Model model, @PathVariable Long id){
        model.addAttribute("cuenta",this.cuentaService.getCuenta(id));
        return "cuenta/cuenta-show";
    }

    @GetMapping(value = "/getCuentaByNumber/{number}")
    public String getCuentaByNumber(Model model, @PathVariable Long number){
        model.addAttribute("cuenta",this.cuentaService.getCuentaByNumber(number));
        return "cuenta/cuenta-show";
    }

    @GetMapping("/new")
    public String newCuenta(Model model){
        model.addAttribute("cuenta", new Cuenta());
        model.addAttribute("accion", "guardar");
        return "cuenta/cuenta-form";
    }
    @PostMapping("/save")
    public String saveCuenta(Cuenta cuenta){
        Cliente cliente = cuenta.getCliente();
        if (cuenta.getTipo().equalsIgnoreCase("prestamo") || cuenta.getTipo().equalsIgnoreCase("credito") && !cuentaService.existsByIdCuenta(cuenta.getIdCuenta())){

            Beneficiario beneficiario=this.crearBeneficiario(cliente, cuenta);
            this.beneficiarioService.save(beneficiario);
            cliente.getBeneficiarios().add(beneficiario);

        }else {
            Beneficiario beneficiario = beneficiarioService.getBeneficiarioByNumeroCuenta(cuenta.getNumeroCuenta());
            Cuenta oldCuenta = cuentaService.getCuenta(cuenta.getIdCuenta());
            oldCuenta.getCliente().getBeneficiarios().remove(beneficiario);
            if(beneficiarioService.existsByIdBeneficiario(beneficiario.getIdBeneficiario())) {
                beneficiarioService.delete(beneficiario.getIdBeneficiario());
            }
            beneficiario=this.crearBeneficiario(cliente ,cuenta);
            this.beneficiarioService.save(beneficiario);
            cliente.getBeneficiarios().add(beneficiario);
        }

        this.cuentaService.save(cuenta);
        return "redirect:/cuenta/getAll";
    }
    @GetMapping("/update/{id}")
    public String updateCuenta(@PathVariable Long id, Model model){
        Cuenta cuenta = this.cuentaService.getCuenta(id);
        model.addAttribute("accion", "actualizar");
        model.addAttribute("cuenta", cuenta);
        return "cuenta/cuenta-form";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        this.cuentaService.delete(id);
        return "redirect:/cuenta/getAll";
    }


    public @ResponseBody List<Cuenta> getAllREST(){
        return this.cuentaService.getAll();
    }

    public Beneficiario crearBeneficiario(Cliente cliente, Cuenta cuenta){

        Beneficiario beneficiario= new Beneficiario();
        beneficiario.setNumeroCuenta(cuenta.getNumeroCuenta());
        //TODO colocar columna moneda a la cuenta
        beneficiario.setMoneda("BOB");

        if(cliente.getTipo().equals(ClienteUtils.PERSONA_NATURAL)){

            // buscar a esa PersonaNatural
            PersonaNatural personaNatural = personaNaturalService.findOneById(cliente.getId());
            beneficiario.setNombreRs(personaNatural.getPersona().getNombres());
            beneficiario.setNitCi(String.valueOf(personaNatural.getPersona().getNumeroDocumento()));
        }else if(cliente.getTipo().equals(ClienteUtils.PERSONA_JURIDICA)){

            // buscar a esa PersonaJuridica
            PersonaJuridica personaJuridica = personaJuridicaService.findOneById(cliente.getId());
            beneficiario.setNombreRs(personaJuridica.getNombreRazon());
            beneficiario.setNitCi(personaJuridica.getNit().toString());
        }

        return beneficiario;
    }
}
