package com.viridian.dummybank.controller;

import com.viridian.dummybank.model.Beneficiario;
import com.viridian.dummybank.model.Cliente;
import com.viridian.dummybank.model.Cuenta;
import com.viridian.dummybank.model.Transaccion;
import com.viridian.dummybank.repository.TransferenciaRepository;
import com.viridian.dummybank.service.*;
import com.viridian.dummybank.utils.TransferenciaUtils;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;
import java.util.Random;

@Controller
public class PagosController {


    private static final Logger log = org.slf4j.LoggerFactory.getLogger(PagosController.class);

    // servicios
    private final ClienteService clienteService;
    private final TransaccionService transaccionService;
    private final AutorizacionService autorizacionService;
    private final EstatusService estatusService;
    private final MetodoService metodoService;
    private final OperacionService operacionService;
    private final BeneficiarioService beneficiarioService;
    private final OperadorService operadorService;
    private final CuentaService cuentaService;
    // repositorio
    private final TransferenciaRepository transferenciaRepository;

    @Autowired
    public PagosController(ClienteService clienteService,
                           TransaccionService transaccionService,
                           TransferenciaRepository transferenciaRepository,
                           AutorizacionService autorizacionService,
                           EstatusService estatusService,
                           MetodoService metodoService,
                           OperacionService operacionService,
                           BeneficiarioService beneficiarioService,
                           OperadorService operadorService,
                           CuentaService cuentaService) {
        this.clienteService = clienteService;
        this.transaccionService = transaccionService;
        this.transferenciaRepository = transferenciaRepository;
        this.autorizacionService = autorizacionService;
        this.estatusService = estatusService;
        this.metodoService = metodoService;
        this.operacionService = operacionService;
        this.beneficiarioService  = beneficiarioService;
        this.operadorService = operadorService;
        this.cuentaService=cuentaService;
    }

    @GetMapping("pago/servicio/{idCliente}")
    public String pagoServicio(@PathVariable String idCliente, Model model){
        // obtener al cliente de la BD
        Cliente cliente = clienteService.findOneById(Long.valueOf(idCliente));
        model.addAttribute("cliente", cliente);
        // obtener los beneficiarios que son de otros bancos
        List<Beneficiario> beneficiarios = transferenciaRepository.getBeneficiariosFromOtherBanksAndByClienteId(Long.valueOf(idCliente));
        model.addAttribute("beneficiarios",beneficiarios);

        model.addAttribute("metodos", metodoService.getAll());
        // cargar la vista
        return "pagos/pago-de-servicios";
    }

    @PostMapping("pago/servicio/validate")
    public String savePagoServicio(HttpServletRequest request , Model model){
        log.info("Recibiendo datos del Pago a realizar");
        // Verificar los datos
        Long numeroCuentaOrigen = Long.valueOf(request.getParameter("origen"));
        Long metodoId = Long.valueOf(request.getParameter("metodo"));
        BigDecimal monto = BigDecimal.valueOf(Long.valueOf(request.getParameter("monto")));
        String moneda = request.getParameter("moneda");
        Long beneficiarioId = Long.valueOf(request.getParameter("beneficiario"));

        //Datos para facturacion
        String nombre = request.getParameter("nombre");
        Long cedulaNit = Long.valueOf(request.getParameter("cedulaNit"));
        Long codServ = Long.valueOf(request.getParameter("codServ"));


        log.info("Creando Un objeto Transaccion");
        // crear un objeto Transaccion con informacion necesaria para la BD

        Transaccion transaccion = new Transaccion();
        transaccion.setNumeroCuenta(numeroCuentaOrigen);
        transaccion.setMonto(monto);
        transaccion.setMoneda(moneda);
        transaccion.setMetodo(metodoService.getMetodoById(metodoId));
        transaccion.setBeneficiario(beneficiarioService.getBeneficiarioById(beneficiarioId));

        log.info("Llenando datos por defecto. REVISAR EN EL FUTURO");
        // considerar los atributos que no se piden
        transaccion.setFechaInicioTS(new Timestamp(System.currentTimeMillis()));
        transaccion.setEstatus(estatusService.getEstatusById(1L));
        transaccion.setOperacion(operacionService.getOperacionById(1L));
        transaccion.setNumeroOrden(15L);
        // introducir la transaccion a la BD
        log.info("Guardando Transaccion en BD");
        transaccionService.save(transaccion);
        log.info("Transaccion Guardada correctamente");


        if(numeroCuentaOrigen == beneficiarioService.getBeneficiarioById(beneficiarioId).getNumeroCuenta()){
            log.error("no puede transferirse entre cuentas propias");

            log.info("Actualizando Transaccion en BD");
            transaccion.setEstatus(estatusService.getEstatusById(3L));
            transaccionService.save(transaccion);
            //TODO actualizar saldo
            log.info("Transaccion Actualizada");

        }else if(cuentaService.getCuentaByNumber(numeroCuentaOrigen).getSaldo().compareTo(monto) < 0) {
            log.error("saldo insuficiente");
            log.info("Actualizando Transaccion en BD");
            transaccion.setEstatus(estatusService.getEstatusById(3L));
            transaccionService.save(transaccion);
            log.info("Transaccion Actualizada");
            //TODO actualizar saldo
        }else {
            log.info("Actualizsar saldo en la BD");
            //TODO Agregar monto a saldo retenido y restar monto a saldo disponible
            //transaccion.setEstatus(estatusService.getEstatusById(2L));
            //TODO CAMBIAR NOMRE FUNCION BY IDTRANSACCION
            transaccionService.updateTansactionAndSaldoCuentaByNuemeroOrden(transaccion.getIdTransaccion(),2L);
            log.info("Transaccion Actualizada correctamente");
        }



        model.addAttribute("transaccion",transaccion);

        return "pagos/pago-de-servicios-show";
    }


    @PostMapping("pago/servicio/send")
    public String sendPagoServicio(HttpServletRequest request , Model model){
        String accion =request.getParameter("accion");
        if(accion.equalsIgnoreCase("continuar")) {

            Long idTransaccion = Long.valueOf(request.getParameter("idTransaccion"));
            Transaccion transaccion= transaccionService.getTransaccionById(idTransaccion);
            //TODO usar nueva consulta para actualizar estatus
            transaccion.setEstatus(estatusService.getEstatusById(5L));
            transaccion.setFechaEjecucion(new Timestamp(System.currentTimeMillis()).toString());
            transaccionService.save(transaccion);
            //
            model.addAttribute("transaccion", transaccionService.getTransaccionById(idTransaccion));
            return "pagos/pago-de-servicios-estatus";
        }else if (accion.equalsIgnoreCase("abortar")){
            Long idTransaccion = Long.valueOf(request.getParameter("idTransaccion"));
            //TODO Restablecer a su estado anterior.
            transaccionService.updateTansactionAndSaldoCuentaByNuemeroOrden(idTransaccion,4L);
            //
            Transaccion transaccion= transaccionService.getTransaccionById(idTransaccion);
            transaccionService.save(transaccion);
            model.addAttribute("transaccion", transaccionService.getTransaccionById(idTransaccion));
            return "pagos/pago-de-servicios-estatus";
        }

        return "redirect:/";
    }

//



    @GetMapping("pago/prestamo/{idCliente}")
    public String pagoPrestamo(@PathVariable Long idCliente, Model model){
        // obtener al cliente de la BD
        Cliente cliente = clienteService.findOneById(idCliente);
        model.addAttribute("cliente", cliente);

        // obtener las cuentas que se muestran sean solo las de tipo prestamo asociadas al cliente
        Cuenta cuentaPrestamoCli = this.cuentaService.getByTipoAndCliente("prestamo",cliente);

        model.addAttribute("cuentasPrestamoCli",cuentaPrestamoCli);

        model.addAttribute("metodos", metodoService.getAll());
        // cargar la vista
        return "pagos/pago-de-prestamos";
    }

    @PostMapping("pago/prestamo/validate")
    public String savePagoPrestamo(HttpServletRequest request , Model model){
        log.info("Recibiendo datos del Pago a realizar");
        // Verificar los datos
        Long numeroCuentaOrigen = Long.valueOf(request.getParameter("origen"));
        BigDecimal monto = BigDecimal.valueOf(Long.valueOf(request.getParameter("monto")));
        String moneda = request.getParameter("moneda");
        Long beneficiarioNumCuenta = Long.valueOf(request.getParameter("beneficiario"));

        //Datos adicionales
        String glosa = request.getParameter("glosa");
        Long autorizacionId = Long.valueOf(request.getParameter("autorizacion"));
        Long metodoId = Long.valueOf(request.getParameter("metodo"));
        Long clienteId = Long.valueOf(request.getParameter("clienteId"));

        log.info("Creando Un objeto Transaccion");
        // crear un objeto Transaccion con informacion necesaria para la BD

        Transaccion transaccion = new Transaccion();
        transaccion.setNumeroCuenta(numeroCuentaOrigen);
        transaccion.setMonto(monto);
        transaccion.setMoneda(moneda);
        transaccion.setMetodo(metodoService.getMetodoById(metodoId));
        transaccion.setBeneficiario(beneficiarioService.getBeneficiarioByClienteIdAndNumeroCuenta(clienteId,beneficiarioNumCuenta));
        transaccion.setConceptoGlosa(glosa);
        transaccion.setAutorizacion(autorizacionService.getAutorizacionById(autorizacionId));
        log.info("Llenando datos por defecto. REVISAR EN EL FUTURO");
        // considerar los atributos que no se piden
        transaccion.setFechaInicioTS(new Timestamp(System.currentTimeMillis()));
        transaccion.setEstatus(estatusService.getEstatusById(1L));
        transaccion.setOperacion(operacionService.getOperacionById(1L));
        transaccion.setNumeroOrden(new Random().nextLong());

        // introducir la transaccion a la BD
        log.info("Guardando Transaccion en BD");
        transaccionService.save(transaccion);
        log.info("Transaccion Guardada correctamente");


        if(numeroCuentaOrigen == beneficiarioService.getBeneficiarioByNumeroCuenta(beneficiarioNumCuenta).getNumeroCuenta()){
            log.error("no puede transferirse entre cuentas propias");

            log.info("Actualizando Transaccion en BD");
            transaccion.setEstatus(estatusService.getEstatusById(3L));
            transaccionService.save(transaccion);
            //TODO actualizar saldo
            log.info("Transaccion Actualizada");

        }else if(cuentaService.getCuentaByNumber(numeroCuentaOrigen).getSaldo().compareTo(monto) < 0) {
            log.error("saldo insuficiente");
            log.info("Actualizando Transaccion en BD");
            transaccion.setEstatus(estatusService.getEstatusById(3L));
            transaccionService.save(transaccion);
            log.info("Transaccion Actualizada");
            //TODO actualizar saldo
        }else {
            log.info("Actualizsar saldo en la BD");
            //TODO Agregar monto a saldo retenido y restar monto a saldo disponible
            //transaccion.setEstatus(estatusService.getEstatusById(2L));
            //TODO CAMBIAR NOMRE FUNCION BY IDTRANSACCION
            transaccionService.updateTansactionAndSaldoCuentaByNuemeroOrden(transaccion.getIdTransaccion(),2L);
            transaccion.setEstatus(estatusService.getEstatusById(2L));
            log.info("Transaccion Actualizada correctamente");
        }



        model.addAttribute("transaccion",transaccion);

        return "pagos/pago-de-prestamos-show";
    }


    @PostMapping("pago/prestamo/send")
    public String sendPagoPrestamo(HttpServletRequest request , Model model){

        String accion =request.getParameter("accion");
        Long idTransaccion = Long.valueOf(request.getParameter("idTransaccion"));

        if(accion.equalsIgnoreCase("continuar")) {
            Transaccion transaccion= transaccionService.getTransaccionById(idTransaccion);

            Transaccion transaccionBeneficiario = new Transaccion();
            transaccionBeneficiario.setNumeroCuenta(transaccion.getNumeroCuenta());
            transaccionBeneficiario.setMonto(transaccion.getMonto());
            transaccionBeneficiario.setMoneda(transaccion.getMoneda());
            transaccionBeneficiario.setMetodo(transaccion.getMetodo());
            transaccionBeneficiario.setBeneficiario(transaccion.getBeneficiario());
            transaccionBeneficiario.setConceptoGlosa(transaccion.getConceptoGlosa());
            transaccionBeneficiario.setAutorizacion(transaccion.getAutorizacion());
            transaccionBeneficiario.setFechaInicioTS(new Timestamp(System.currentTimeMillis()));

            transaccionBeneficiario.setEstatus(transaccion.getEstatus());
            transaccionBeneficiario.setOperacion(operacionService.getOperacionById(2L));
            transaccionBeneficiario.setNumeroOrden(transaccion.getNumeroOrden());
            transaccionBeneficiario.setSaldo(BigDecimal.ZERO);
            transaccionService.save(transaccionBeneficiario);

            transaccionBeneficiario = transaccionService.getTransaccionById(transaccionBeneficiario.getIdTransaccion());
            transaccionService.updateCuentaBeneficiarioAndSaldoAndEstatusByIdTransaccion(transaccionBeneficiario.getIdTransaccion());

            //TODO usar nueva consulta para actualizar estatus
            transaccion.setEstatus(estatusService.getEstatusById(5L));
            transaccion.setFechaEjecucion(new Timestamp(System.currentTimeMillis()).toString());
            transaccionService.save(transaccion);
            //
            model.addAttribute("transaccion", transaccionService.getTransaccionById(idTransaccion));
            return "pagos/pago-de-prestamos-estatus";
        }else if (accion.equalsIgnoreCase("abortar")){
            //TODO Restablecer a su estado anterior.
            transaccionService.updateTansactionAndSaldoCuentaByNuemeroOrden(idTransaccion,4L);
            //
            Transaccion transaccion= transaccionService.getTransaccionById(idTransaccion);
            transaccionService.save(transaccion);
            model.addAttribute("transaccion", transaccionService.getTransaccionById(idTransaccion));
            return "pagos/pago-de-prestamos-estatus";
        }

        return "redirect:/";
    }



    @GetMapping("pago/tarjeta/{idCliente}")
    public String pagoTarjeta(@PathVariable Long idCliente, Model model){
        // obtener al cliente de la BD
        Cliente cliente = clienteService.findOneById(idCliente);
        model.addAttribute("cliente", cliente);

        // obtener las cuentas que se muestran sean solo las de tipo tarjeta asociadas al cliente
        Cuenta cuentaTarjeta = this.cuentaService.getByTipoAndCliente("credito",cliente);

        model.addAttribute("cuentasTarjeta",cuentaTarjeta);

        model.addAttribute("metodos", metodoService.getAll());
        // cargar la vista
        return "pagos/pago-de-tarjetas";
    }

    @PostMapping("pago/tarjeta/validate")
    public String savePagoTarjetas(HttpServletRequest request , Model model){
        log.info("Recibiendo datos del Pago a realizar");
        // Verificar los datos
        Long numeroCuentaOrigen = Long.valueOf(request.getParameter("origen"));
        BigDecimal monto = BigDecimal.valueOf(Long.valueOf(request.getParameter("monto")));
        String moneda = request.getParameter("moneda");
        Long beneficiarioNumCuenta = Long.valueOf(request.getParameter("beneficiario"));

        //Datos adicionales
        String glosa = request.getParameter("glosa");
        Long autorizacionId = Long.valueOf(request.getParameter("autorizacion"));
        Long metodoId = Long.valueOf(request.getParameter("metodo"));
        Long clienteId = Long.valueOf(request.getParameter("clienteId"));

        log.info("Creando Un objeto Transaccion");
        // crear un objeto Transaccion con informacion necesaria para la BD

        Transaccion transaccion = new Transaccion();
        transaccion.setNumeroCuenta(numeroCuentaOrigen);
        transaccion.setMonto(monto);
        transaccion.setMoneda(moneda);
        transaccion.setMetodo(metodoService.getMetodoById(metodoId));
        transaccion.setBeneficiario(beneficiarioService.getBeneficiarioByClienteIdAndNumeroCuenta(clienteId,beneficiarioNumCuenta));
        transaccion.setConceptoGlosa(glosa);
        transaccion.setAutorizacion(autorizacionService.getAutorizacionById(autorizacionId));
        log.info("Llenando datos por defecto. REVISAR EN EL FUTURO");
        // considerar los atributos que no se piden
        transaccion.setFechaInicioTS(new Timestamp(System.currentTimeMillis()));
        transaccion.setEstatus(estatusService.getEstatusById(1L));
        transaccion.setOperacion(operacionService.getOperacionById(1L));
        transaccion.setNumeroOrden(new Random().nextLong());

        // introducir la transaccion a la BD
        log.info("Guardando Transaccion en BD");
        transaccionService.save(transaccion);
        log.info("Transaccion Guardada correctamente");


        if(numeroCuentaOrigen == beneficiarioService.getBeneficiarioByNumeroCuenta(beneficiarioNumCuenta).getNumeroCuenta()){
            log.error("no puede transferirse entre cuentas propias");

            log.info("Actualizando Transaccion en BD");
            transaccion.setEstatus(estatusService.getEstatusById(3L));
            transaccionService.save(transaccion);
            //TODO actualizar saldo
            log.info("Transaccion Actualizada");

        }else if(cuentaService.getCuentaByNumber(numeroCuentaOrigen).getSaldo().compareTo(monto) < 0) {
            log.error("saldo insuficiente");
            log.info("Actualizando Transaccion en BD");
            transaccion.setEstatus(estatusService.getEstatusById(3L));
            transaccionService.save(transaccion);
            log.info("Transaccion Actualizada");
            //TODO actualizar saldo
        }else {
            log.info("Actualizsar saldo en la BD");
            //TODO Agregar monto a saldo retenido y restar monto a saldo disponible
            //transaccion.setEstatus(estatusService.getEstatusById(2L));
            //TODO CAMBIAR NOMRE FUNCION BY IDTRANSACCION
            transaccionService.updateTansactionAndSaldoCuentaByNuemeroOrden(transaccion.getIdTransaccion(),2L);
            transaccion.setEstatus(estatusService.getEstatusById(2L));
            log.info("Transaccion Actualizada correctamente");
        }



        model.addAttribute("transaccion",transaccion);

        return "pagos/pago-de-tarjetas-show";
    }


    @PostMapping("pago/tarjeta/send")
    public String sendPagoTarjetas(HttpServletRequest request , Model model){

        String accion =request.getParameter("accion");
        Long idTransaccion = Long.valueOf(request.getParameter("idTransaccion"));

        if(accion.equalsIgnoreCase("continuar")) {
            Transaccion transaccion= transaccionService.getTransaccionById(idTransaccion);

            Transaccion transaccionBeneficiario = new Transaccion();
            transaccionBeneficiario.setNumeroCuenta(transaccion.getNumeroCuenta());
            transaccionBeneficiario.setMonto(transaccion.getMonto());
            transaccionBeneficiario.setMoneda(transaccion.getMoneda());
            transaccionBeneficiario.setMetodo(transaccion.getMetodo());
            transaccionBeneficiario.setBeneficiario(transaccion.getBeneficiario());
            transaccionBeneficiario.setConceptoGlosa(transaccion.getConceptoGlosa());
            transaccionBeneficiario.setAutorizacion(transaccion.getAutorizacion());
            transaccionBeneficiario.setFechaInicioTS(new Timestamp(System.currentTimeMillis()));

            transaccionBeneficiario.setEstatus(transaccion.getEstatus());
            transaccionBeneficiario.setOperacion(operacionService.getOperacionById(2L));
            transaccionBeneficiario.setNumeroOrden(transaccion.getNumeroOrden());
            transaccionBeneficiario.setSaldo(BigDecimal.ZERO);
            transaccionService.save(transaccionBeneficiario);

            transaccionBeneficiario = transaccionService.getTransaccionById(transaccionBeneficiario.getIdTransaccion());
            transaccionService.updateCuentaBeneficiarioAndSaldoAndEstatusByIdTransaccion(transaccionBeneficiario.getIdTransaccion());

            //TODO usar nueva consulta para actualizar estatus
            transaccion.setEstatus(estatusService.getEstatusById(5L));
            transaccion.setFechaEjecucion(new Timestamp(System.currentTimeMillis()).toString());
            transaccionService.save(transaccion);
            //
            model.addAttribute("transaccion", transaccionService.getTransaccionById(idTransaccion));
            return "pagos/pago-de-tarjetas-estatus";

        }else if (accion.equalsIgnoreCase("abortar")){
            //TODO Restablecer a su estado anterior.
            transaccionService.updateTansactionAndSaldoCuentaByNuemeroOrden(idTransaccion,4L);
            //
            Transaccion transaccion= transaccionService.getTransaccionById(idTransaccion);
            transaccionService.save(transaccion);
            model.addAttribute("transaccion", transaccionService.getTransaccionById(idTransaccion));
            return "pagos/pago-de-tarjetas-estatus";
        }

        return "redirect:/";
    }


}
