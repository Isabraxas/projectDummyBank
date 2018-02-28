package com.viridian.dummybank.controller;

import com.viridian.dummybank.model.Cliente;
import com.viridian.dummybank.model.Cuenta;
import com.viridian.dummybank.model.Transaccion;
import com.viridian.dummybank.repository.TransferenciaRepository;
import com.viridian.dummybank.service.ClienteService;
import com.viridian.dummybank.service.TransaccionService;
import com.viridian.dummybank.utils.TransferenciaUtils;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created by marcelo on 27-02-18
 */
@Controller
public class TransferenciasController {

    // logger
    private static final Logger log = org.slf4j.LoggerFactory.getLogger(TransferenciasController.class);

    // servicios
    private final ClienteService clienteService;
    private final TransaccionService transaccionService;
    // repositorio
    private final TransferenciaRepository transferenciaRepository;

    @Autowired
    public TransferenciasController(ClienteService clienteService,
                                    TransaccionService transaccionService,
                                    TransferenciaRepository transferenciaRepository) {
        this.clienteService = clienteService;
        this.transaccionService = transaccionService;
        this.transferenciaRepository = transferenciaRepository;
    }

    @GetMapping("transferencia/propias/{idCliente}")
    public String transferenciaCuentasPropias(@PathVariable String idCliente, Model model){
        log.info("Creando nueva Transferencia entre cuentas propias.");
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
        log.info("Recibiendo datos de la transferencia a realizar");
        // obtener los datos de la transferencia propia
        Long numeroCuentaOrigen = Long.valueOf(request.getParameter("origen"));
        Long numeroCuentaDestino = Long.valueOf(request.getParameter("destino"));
        BigDecimal monto = BigDecimal.valueOf(Long.valueOf(request.getParameter("monto")));
        String moneda = request.getParameter("moneda");
        String glosa = request.getParameter("glosa");
        Long autorizacion = Long.valueOf(request.getParameter("autorizacion"));
        Long regAsfi = Long.valueOf(request.getParameter("regAsfi"));
        /*
        System.out.println( "id cuenta origen: " + request.getParameter("origen"));
        System.out.println( "id cuenta destino: " + request.getParameter("destino"));
        System.out.println( "monto: " + request.getParameter("monto"));
        System.out.println( "moneda: " + request.getParameter("moneda"));
        System.out.println( "glosa: " + request.getParameter("glosa"));
        System.out.println( "autorizacion: " + request.getParameter("autorizacion"));
        System.out.println( "regAsif: " + request.getParameter("regAsfi"));
        */
        if(numeroCuentaOrigen == numeroCuentaDestino){
            log.error("no puede transferirse entre cuentas propias");
            // todo Error Transferencia entre cuentas propias, misma cuenta
        }
        // todo Error saldo insuficiente

        log.info("Creando Un objeto Transaccion");
        // crear un objeto Transaccion con informacion necesaria para la BD
        Transaccion transaccion = new Transaccion();
        transaccion.setNumeroCuenta(numeroCuentaOrigen);
        transaccion.setMonto(monto);
        transaccion.setMoneda(moneda);
        transaccion.setConceptoGlosa(glosa);
        transaccion.setAutorizacionId(autorizacion);
        transaccion.setRegisAsfi(regAsfi);
        log.info("Llenando datos por defecto. REVISAR EN EL FUTURO");
            // considerar los atributos que no se piden
        transaccion.setEstatusId(TransferenciaUtils.STATUS_COMPLETA);
        transaccion.setAutorizacionId(TransferenciaUtils.AUTORIZACION_DEF);
        transaccion.setMetodoId(TransferenciaUtils.METODO_CUENTAS_PROPIAS);
        transaccion.setNumeroOrden(TransferenciaUtils.NUMERO_ORDEN_DEF);
        transaccion.setOperacionId(TransferenciaUtils.OPERACION_DEPOSITO);
        transaccion.setOperador(TransferenciaUtils.OPERADOR_DEF);
        transaccion.setRegistroFacturacion(TransferenciaUtils.REGISTRO_FACTURACION);
        transaccion.setBeneficiarioId(TransferenciaUtils.BENEFICIARIO_DEF);
        transaccion.setFechaInicioTS(new Timestamp(System.currentTimeMillis()));
        transaccion.setSaldo(TransferenciaUtils.SALDO_DEF);

        // introducir la transaccion a la BD
        log.info("Guardando Transaccion en BD");
        transaccionService.save(transaccion);
        log.info("Transaccion Guardada correctamente");
        return "redirect:/";
    }


    @GetMapping("transferencia/terceros/{idCliente}")
    public String transferenciaCuentasTerceros(@PathVariable String idCliente, Model model){
        // obtener al cliente de la BD
        Cliente cliente = clienteService.findOneById(Long.valueOf(idCliente));
        model.addAttribute("cliente", cliente);
        // obtener las cuentas de los beneficiarios registrados al cliente por su Id
        List<Long> cuentas = transferenciaRepository.getCuentas(Long.valueOf(idCliente));
        // cargarlos al modelo
        model.addAttribute("cuentas", cuentas);
        // cargar la vista
        return "transferencias/transferencia-terceros";
    }
}
