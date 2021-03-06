package com.viridian.dummybank.controller;

import com.viridian.dummybank.model.*;

import com.viridian.dummybank.service.ClienteService;
import com.viridian.dummybank.service.TransaccionService;

import com.viridian.dummybank.repository.TransferenciaRepository;
import com.viridian.dummybank.service.*;

import com.viridian.dummybank.utils.TransferenciaUtils;
import jdk.internal.dynalink.MonomorphicCallSite;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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
    private final AutorizacionService autorizacionService;
    private final EstatusService estatusService;
    private final MetodoService metodoService;
    private final OperacionService operacionService;
    private final BeneficiarioService beneficiarioService;
    private final OperadorService operadorService;
    // repositorio
    private final TransferenciaRepository transferenciaRepository;

    @Autowired
    public TransferenciasController(ClienteService clienteService,
                                    TransaccionService transaccionService,
                                    TransferenciaRepository transferenciaRepository,
                                    AutorizacionService autorizacionService,
                                    EstatusService estatusService,
                                    MetodoService metodoService,
                                    OperacionService operacionService,
                                    BeneficiarioService beneficiarioService,
                                    OperadorService operadorService) {
        this.clienteService = clienteService;
        this.transaccionService = transaccionService;
        this.transferenciaRepository = transferenciaRepository;
        this.autorizacionService = autorizacionService;
        this.estatusService = estatusService;
        this.metodoService = metodoService;
        this.operacionService = operacionService;
        this.beneficiarioService  = beneficiarioService;
        this.operadorService = operadorService;
    }

    @GetMapping("transferencia/selec-cliente")
    public String clientesBanco(Model model){
        log.info("Cargando list de clientes");
        model.addAttribute("clientes",clienteService.findAllClientes());
        return "transferencias/transferencia-selec-cliente";
    }

    @PostMapping("transferencia/setCliente")
    public String settingCliente(HttpServletRequest request, Model model){
        Long idCliente = Long.valueOf(request.getParameter("cliente"));
        log.info("Cargando las posibles transferencias para el Cliente Id: "+ idCliente);
        model.addAttribute("cliente",idCliente);
        return "transferencias/transferencia-menu";
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

        model.addAttribute("metodo",TransferenciaUtils.METODO_CUENTAS_PROPIAS);
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
        Autorizacion autorizacion = new Autorizacion();
        Long regAsfi = Long.valueOf(request.getParameter("regAsfi"));

        Long metodoId = Long.valueOf(request.getParameter("metodo"));
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

        transaccion.setAutorizacion(autorizacion);
        transaccion.setRegisAsfi(regAsfi);
        log.info("Llenando datos por defecto. REVISAR EN EL FUTURO");
            // considerar los atributos que no se piden
        transaccion.setEstatus(new Estatus());
        transaccion.setAutorizacion(new Autorizacion("A-3" , "non se"));
        transaccion.setMetodo(new Metodo());
        transaccion.setNumeroOrden(TransferenciaUtils.NUMERO_ORDEN_DEF);
        transaccion.setOperacion(new Operacion());
        transaccion.setOperador(new Operador());
        transaccion.setRegistroFacturacion(TransferenciaUtils.REGISTRO_FACTURACION);
        transaccion.setBeneficiario(new Beneficiario());

        transaccion.setAutorizacion(autorizacion);
        transaccion.setRegisAsfi(regAsfi);
        log.info("Llenando datos por defecto. REVISAR EN EL FUTURO");
            // considerar los atributos que no se piden
        transaccion.setEstatus(estatusService.getEstatusById(TransferenciaUtils.STATUS_PARC_COMPR));
        transaccion.setMetodo(metodoService.getMetodoById(metodoId));
        transaccion.setNumeroOrden(TransferenciaUtils.NUMERO_ORDEN_DEF);
        transaccion.setOperacion(operacionService.getOperacionById(TransferenciaUtils.OPERACION_DEPOSITO));
        transaccion.setOperador(operadorService.getOperadorById(TransferenciaUtils.OPERADOR_DEF));
        transaccion.setRegistroFacturacion(TransferenciaUtils.REGISTRO_FACTURACION);
        transaccion.setBeneficiario(beneficiarioService.getBeneficiarioById(TransferenciaUtils.BENEFICIARIO_DEF));

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
        //List<Long> cuentas = transferenciaRepository.getCuentas(Long.valueOf(idCliente));
        List<Beneficiario> beneficiarios = transferenciaRepository.getThirdBeneficiariosFromThisBankAndByClienteId(Long.valueOf(idCliente));
        // cargarlos al modelo
        //model.addAttribute("cuentas", cuentas);
        model.addAttribute("beneficiarios",beneficiarios);

        model.addAttribute("metodo",TransferenciaUtils.METODO_CUENTAS_TERCEROS);
        // cargar la vista
        return "transferencias/transferencia-terceros";
    }


    @GetMapping("transferencia/otros/{idCliente}")
    public String transferenciaCuentasExternas(@PathVariable String idCliente, Model model){
        // obtener al cliente de la BD
        Cliente cliente = clienteService.findOneById(Long.valueOf(idCliente));
        model.addAttribute("cliente", cliente);
        // obtener los beneficiarios que son de otros bancos
        List<Beneficiario> beneficiarios = transferenciaRepository.getBeneficiariosFromOtherBanksAndByClienteId(Long.valueOf(idCliente));
        model.addAttribute("beneficiarios",beneficiarios);

        model.addAttribute("metodo", TransferenciaUtils.METODO_CUENTAS_OTROS);
        // cargar la vista
        return "transferencias/transferencia-otros";
    }

    @GetMapping("transferencia/reversion/{idTransaccion}/{idAutorizacion}")
    public String revertirTransaccion(@PathVariable String idTransaccion, @PathVariable String idAutorizacion, Model model){
        log.info("Revertiendo operacion id: " + idTransaccion);
        log.info("Verificando Autorizacion");
        // verificar que tiene autorizacion para revertir
        if(Long.valueOf(idAutorizacion) == TransferenciaUtils.AUTORIZACION_PARA_REVERTIR){
            // tiene autorizacion
            log.info("Autorizacion Aceptada");
            log.info("Buscando Transaccion");
            Transaccion transaccion = transaccionService.getTransaccionById(Long.valueOf(idTransaccion));
            log.info("Transaccion Encontrada");
            // REVERTIR TRANSACCION
            Transaccion transaccionRevertida = new Transaccion();
            Beneficiario beneficiario = transaccion.getBeneficiario();
            transaccionRevertida.setNumeroCuenta(beneficiario.getNumeroCuenta());
            transaccionRevertida.setMonto(transaccion.getMonto());
            transaccionRevertida.setMoneda(transaccion.getMoneda());
            transaccionRevertida.setConceptoGlosa("REVERSION TRANSACCION: " + idTransaccion);
            transaccionRevertida.setAutorizacion(autorizacionService.getAutorizacionById(Long.valueOf(idAutorizacion)));
            transaccionRevertida.setEstatus(estatusService.getEstatusById(TransferenciaUtils.STATUS_PARC_COMPR));
            transaccionRevertida.setMetodo(metodoService.getMetodoById(TransferenciaUtils.METODO_REVERSION));
            transaccionRevertida.setFechaInicioTS(new Timestamp(System.currentTimeMillis()));
            transaccionRevertida.setSaldo(TransferenciaUtils.SALDO_DEF);// CALCULAR LUEGO (?)
            // beneficiario
            Beneficiario beneficiarioRev = beneficiarioService.getBeneficiarioByNumeroCuenta(transaccion.getNumeroCuenta());
            if(beneficiarioRev == null){
                beneficiarioRev = new Beneficiario();
                beneficiarioRev.setBanco(beneficiario.getBanco());
                beneficiarioRev.setIdBeneficiario(beneficiario.getIdBeneficiario());
                beneficiarioRev.setMoneda(beneficiario.getMoneda());
                beneficiarioRev.setMonto(beneficiario.getMonto());
                beneficiarioRev.setNitCi(beneficiario.getNitCi());
                beneficiarioRev.setNombreRs(beneficiario.getNombreRs());
                beneficiarioRev.setNumeroCuenta(beneficiario.getNumeroCuenta());

                beneficiarioRev.setTransaccions(beneficiario.getTransaccions());
                beneficiarioService.save(beneficiario);
            }
            transaccionRevertida.setBeneficiario(beneficiarioRev);


            transaccionRevertida.setRegisAsfi(transaccion.getRegisAsfi());
            transaccionRevertida.setNumeroOrden(TransferenciaUtils.NUMERO_ORDEN_DEF);
            transaccionRevertida.setOperacion(operacionService.getOperacionById(TransferenciaUtils.OPERACION_DEPOSITO));
            transaccionRevertida.setOperador(operadorService.getOperadorById(TransferenciaUtils.OPERADOR_DEF));
            transaccionRevertida.setRegistroFacturacion(transaccion.getRegistroFacturacion());


            transaccionService.save(transaccionRevertida);

            model.addAttribute("mensaje", "transaccion revertida");
        }else{
            // no tienen autorizacion
            log.info("Autorizacion Denegada");
            model.addAttribute("mensaje", "reversion fallida");
        }
        return "transferencias/transferencia-reversion-res";
    }
}
