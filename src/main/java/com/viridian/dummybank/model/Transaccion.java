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

    @Column(name = "metodo_id", nullable = false)
    private Long metodoId ;

    @Column(name = "estatus_id", nullable = false)
    private Long estatusId ;

    @Column(name = "autorizacion_id", nullable = false)
    private Long autorizacionId;

    @Column(name = "operacion_id", nullable = false)
    private Long operacionId ;

    @Column(name = "concepto_glosa", nullable = false)
    //Cambiar el tipo por varchar en la bd
    private String conceptoGlosa;

    @Column(name = "monto", nullable = false)
    private BigDecimal monto ;

    @Column(name = "moneda", nullable = false)
    private String moneda;

    @Column(name = "saldo", nullable = false)
    private BigDecimal saldo ;

    @Column(name = "beneficiario_id", nullable = false)
    private Long beneficiarioId;

    @Column(name = "operador_id", nullable = false)
    private Long operadorId;

    @Column(name = "regis_asfi", nullable = false)
    private Long regisAsfi;

    @Column(name = "registro_facturacion", nullable = false)
    private Long registroFacturacion;



    public Transaccion (){

    }

    public Transaccion(Long numeroCuenta, Timestamp fechaInicio, Timestamp fechaAprobacion, Timestamp fechaEjecucion, Long numeroOrden, Long metodoId, Long estatusId, Long autorizacionId, Long operacionId, String conceptoGlosa, BigDecimal monto, String moneda, BigDecimal saldo, Long beneficiarioId, Long operadorId, Long regisAsfi, Long registroFacturacion) {
        this.numeroCuenta = numeroCuenta;
        this.fechaInicio = fechaInicio;
        this.fechaAprobacion = fechaAprobacion;
        this.fechaEjecucion = fechaEjecucion;
        this.numeroOrden = numeroOrden;
        this.metodoId = metodoId;
        this.estatusId = estatusId;
        this.autorizacionId = autorizacionId;
        this.operacionId = operacionId;
        this.conceptoGlosa = conceptoGlosa;
        this.monto = monto;
        this.moneda = moneda;
        this.saldo = saldo;
        this.beneficiarioId = beneficiarioId;
        this.operadorId = operadorId;
        this.regisAsfi = regisAsfi;
        this.registroFacturacion = registroFacturacion;
    }

    public Transaccion(Long numeroCuenta, Long numeroOrden, Long metodoId, Long estatusId, Long autorizacionId, Long operacionId, String conceptoGlosa, BigDecimal monto, String moneda, BigDecimal saldo, Long beneficiarioId, Long operadorId, Long regisAsfi, Long registroFacturacion) {
        this.numeroCuenta = numeroCuenta;
        this.numeroOrden = numeroOrden;
        this.metodoId = metodoId;
        this.estatusId = estatusId;
        this.autorizacionId = autorizacionId;
        this.operacionId = operacionId;
        this.conceptoGlosa = conceptoGlosa;
        this.monto = monto;
        this.moneda = moneda;
        this.saldo = saldo;
        this.beneficiarioId = beneficiarioId;
        this.operadorId = operadorId;
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

    public Long getOperador() {
        return operadorId;
    }

    public void setOperador(Long operadorId) {
        this.operadorId = operadorId;
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


    public Long getMetodoId() {
        return metodoId;
    }

    public void setMetodoId(Long metodoId) {
        this.metodoId = metodoId;
    }

    public Long getEstatusId() {
        return estatusId;
    }

    public void setEstatusId(Long estatusId) {
        this.estatusId = estatusId;
    }

    public Long getAutorizacionId() {
        return autorizacionId;
    }

    public void setAutorizacionId(Long autorizacionId) {
        this.autorizacionId = autorizacionId;
    }

    public Long getOperacionId() {
        return operacionId;
    }

    public void setOperacionId(Long operacionId) {
        this.operacionId = operacionId;
    }

    public Long getBeneficiarioId() {
        return beneficiarioId;
    }

    public void setBeneficiarioId(Long beneficiarioId) {
        this.beneficiarioId = beneficiarioId;
    }
}
