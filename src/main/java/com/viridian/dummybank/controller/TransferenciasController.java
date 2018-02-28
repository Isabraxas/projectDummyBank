package com.viridian.dummybank.controller;

import com.viridian.dummybank.model.Cliente;
import com.viridian.dummybank.model.Cuenta;
import com.viridian.dummybank.model.Transaccion;
import com.viridian.dummybank.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by marcelo on 27-02-18
 */
@Controller
public class TransferenciasController {

    // servicios
    private final ClienteService clienteService;

    @Autowired
    public TransferenciasController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping("transferencia/propias/{idCliente}")
    public String transferenciaCuentasPropias(@PathVariable String idCliente, Model model){
        // obtener al cliente desde la BD
        Cliente cliente = clienteService.findOneById(Long.valueOf(idCliente));
        model.addAttribute(cliente);
        // obtener las cuentas del cliente
        List<Cuenta> cuentas = cliente.getCuentas();
        // adicionar las cuentas al modelo
        model.addAttribute("cuentas", cuentas);
        // cargar la vista
        return "transferencias/transferencia-propias";
    }

    @PostMapping("transferencia/propias/save")
    public String saveTransferenciaPropia(HttpServletRequest request){
        // obtener los datos de la transferencia propia
        /**/
        System.out.println( "id cuenta origen: " + request.getParameter("origen"));
        System.out.println( "id cuenta destino: " + request.getParameter("destino"));
        System.out.println( "monto: " + request.getParameter("monto"));
        System.out.println( "moneda: " + request.getParameter("moneda"));
        System.out.println( "glosa: " + request.getParameter("glosa"));
        System.out.println( "autorizacion: " + request.getParameter("autorizacion"));
        System.out.println( "regAsif: " + request.getParameter("regAsfi"));
        /**/
        // crear un objeto Transaccion con informacion necesaria para la BD
            // considerar los atributos que no se piden
        // introducir la transaccion a la BD
        // todo completar el registro de la transaccion
        Transaccion transaccion = new Transaccion();
        return "redirect:/";
    }
}
