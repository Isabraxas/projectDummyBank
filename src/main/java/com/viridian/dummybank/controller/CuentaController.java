package com.viridian.dummybank.controller;


import com.viridian.dummybank.model.Beneficiario;
import com.viridian.dummybank.model.Cliente;
import com.viridian.dummybank.model.Cuenta;
import com.viridian.dummybank.service.BeneficiarioService;
import com.viridian.dummybank.service.CuentaService;
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
        if (cuenta.getTipo().equalsIgnoreCase("prestamo")){
            Cliente cliente = cuenta.getCliente();
            Beneficiario beneficiario= new Beneficiario();
            beneficiario.setNumeroCuenta(cuenta.getNumeroCuenta());
            //TODO colocar columna moneda a la cuenta
            beneficiario.setMoneda("BOB");
            //TODO hacer algo con la la relacion cliente persona no puedo obtener datos para llenar beneficiario
            beneficiario.setNombreRs("YO");
            beneficiario.setNitCi("7777777");

            this.beneficiarioService.save(beneficiario);

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
}
