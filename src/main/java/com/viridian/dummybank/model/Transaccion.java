package com.viridian.dummybank.model;

import com.viridian.dummybank.util.Util;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@Entity
@Table(name="Transaccion")
@Access(AccessType.FIELD)
public class Transaccion implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_transaccion", nullable = false)
    //Recomendable colocar comoconvencion id_[nombre_tabla] para las PK
    //y  [nombre_tabla]_id para las FK
    private Long idTransaccion;

    @Column(name = "numero_cuenta", nullable = false)
    private Long numeroCuenta;

    @Column(name = "fecha_inicio", nullable = false)
    private Timestamp fechaInicio ;

    @Column(name = "fecha_aprobacion", nullable = true)
    private Timestamp fechaAprobacion;

    @Column(name = "fecha_ejecucion", nullable = true)
    private Timestamp fechaEjecucion;

    @Column(name = "numero_orden", nullable = false)
    private Long numeroOrden;
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "metodo_id")
    private Metodo metodo ;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "estatus_id")
    private Estatus estatus ;
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "autorizacion_id")
    private Autorizacion autorizacion;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "operacion_id")
    private Operacion operacion;

    @Column(name = "concepto_glosa", nullable = false)
    //Cambiar el tipo por varchar en la bd
    private String conceptoGlosa;

    @Column(name = "monto", nullable = false)
    private BigDecimal monto ;

    @Column(name = "moneda", nullable = false)
    private String moneda;

    @Column(name = "saldo", nullable = false)
    private BigDecimal saldo ;
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "beneficiario_id")
    private Beneficiario beneficiario;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "operador_id")
    private Operador operador;

    @Column(name = "regis_asfi", nullable = false)
    private Long regisAsfi;

    @Column(name = "registro_facturacion", nullable = false)
    private Long registroFacturacion;



    public Transaccion (){

    }

    public Transaccion(Long numeroCuenta, Timestamp fechaInicio, Timestamp fechaAprobacion, Timestamp fechaEjecucion, Long numeroOrden, Metodo metodo, Estatus estatus, Autorizacion autorizacion, Operacion operacion, String conceptoGlosa, BigDecimal monto, String moneda, BigDecimal saldo, Beneficiario beneficiario, Operador operador, Long regisAsfi, Long registroFacturacion) {
        this.numeroCuenta = numeroCuenta;
        this.fechaInicio = fechaInicio;
        this.fechaAprobacion = fechaAprobacion;
        this.fechaEjecucion = fechaEjecucion;
        this.numeroOrden = numeroOrden;
        this.metodo = metodo;
        this.estatus = estatus;
        this.autorizacion = autorizacion;
        this.operacion = operacion;
        this.conceptoGlosa = conceptoGlosa;
        this.monto = monto;
        this.moneda = moneda;
        this.saldo = saldo;
        this.beneficiario = beneficiario;
        this.operador = operador;
        this.regisAsfi = regisAsfi;
        this.registroFacturacion = registroFacturacion;
    }

    public Transaccion(Long numeroCuenta, Long numeroOrden, Metodo metodo, Estatus estatus, Autorizacion autorizacion, Operacion operacion, String conceptoGlosa, BigDecimal monto, String moneda, BigDecimal saldo, Beneficiario beneficiario, Operador operador, Long regisAsfi, Long registroFacturacion) {
        this.numeroCuenta = numeroCuenta;
        this.numeroOrden = numeroOrden;
        this.metodo = metodo;
        this.estatus = estatus;
        this.autorizacion = autorizacion;
        this.operacion = operacion;
        this.conceptoGlosa = conceptoGlosa;
        this.monto = monto;
        this.moneda = moneda;
        this.saldo = saldo;
        this.beneficiario = beneficiario;
        this.operador = operador;
        this.regisAsfi = regisAsfi;
        this.registroFacturacion = registroFacturacion;
    }

    public Long getIdTransaccion() {
        return idTransaccion;
    }

    public void setIdTransaccion(Long idTransaccion) {
        this.idTransaccion = idTransaccion;
    }

    public Long getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(Long numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }


/*
    public Timestamp getFechaInicio() {
        return fechaInicio;
    }

    Set original de fecha inicio
    public void setFechaInicio(Timestamp fechaInicio) {
        this.fechaInicio = fechaInicio;
    }
    */
    public String getFechaInicio() {
        if(fechaInicio == null){
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss.SSS");
            String formattedDateTime = LocalDateTime.now().format(formatter);
            return formattedDateTime;

        }else {
            return fechaInicio.toString();
        }
    }
    public void setFechaInicio(String str_date)  {
            Timestamp nuevaFechaInicio;
            nuevaFechaInicio= Util.convertStringToTimestamp(str_date);
            this.fechaInicio = nuevaFechaInicio;

    }
    // añadido por marcelo
    public void setFechaInicioTS(Timestamp date)  {
        this.fechaInicio = date;
    }
    //--------------------

    public String getFechaAprobacion() {
        if(fechaAprobacion == null){
            return "0000-00-00 00:00:00";
        }else {
            return fechaAprobacion.toString();
        }

    }

    public void setFechaAprobacion(String str_date) {
        Timestamp nuevaFechaAprobacion;
        nuevaFechaAprobacion= Util.convertStringToTimestamp(str_date);

         this.fechaAprobacion = nuevaFechaAprobacion;
    }

    public String getFechaEjecucion() {
        if(fechaEjecucion == null){
            return "0000-00-00 00:00:00";
        }else {
            return fechaEjecucion.toString();
        }

    }

    public void setFechaEjecucion(String str_date) {
        Timestamp nuevaFechaEjecucion;
        nuevaFechaEjecucion= Util.convertStringToTimestamp(str_date);
        this.fechaEjecucion = nuevaFechaEjecucion;
    }

    public Long getNumeroOrden() {
        return numeroOrden;
    }

    public void setNumeroOrden(Long numeroOrden) {
        this.numeroOrden = numeroOrden;
    }


    public String getConceptoGlosa() {
        return conceptoGlosa;
    }

    public void setConceptoGlosa(String conceptoGlosa) {
        this.conceptoGlosa = conceptoGlosa;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public Operador getOperador() {
        return operador;
    }

    public void setOperador(Operador operador) {
        this.operador = operador;
    }

    public Long getRegisAsfi() {
        return regisAsfi;
    }

    public void setRegisAsfi(Long regisAsfi) {
        this.regisAsfi = regisAsfi;
    }

    public Long getRegistroFacturacion() {
        return registroFacturacion;
    }

    public void setRegistroFacturacion(Long registroFacturacion) {
        this.registroFacturacion = registroFacturacion;
    }


    //TODO eliminar los metodos a los que estos sustituyen


    public Metodo getMetodo() {
        return metodo;
    }

    public void setMetodo(Metodo metodo) {
        this.metodo = metodo;
    }

    public Estatus getEstatus() {
        return estatus;
    }

    public void setEstatus(Estatus estatus) {
        this.estatus = estatus;
    }

    public Autorizacion getAutorizacion() {
        return autorizacion;
    }

    public void setAutorizacion(Autorizacion autorizacion) {
        this.autorizacion = autorizacion;
    }

    public Operacion getOperacion() {
        return operacion;
    }

    public void setOperacion(Operacion operacion) {
        this.operacion = operacion;
    }

    public Beneficiario getBeneficiario() {
        return beneficiario;
    }

    public void setBeneficiario(Beneficiario beneficiario) {
        this.beneficiario = beneficiario;
    }
}
