package com.viridian.dummybank.model;

import com.viridian.dummybank.util.Util;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.ParseException;


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

    @Column(name = "fecha_aprobacion", nullable = false)
    private Timestamp fechaAprobacion;

    @Column(name = "fecha_ejecucion", nullable = false)
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
    private Long operador;

    @Column(name = "regis_asfi", nullable = false)
    private Long regisAsfi;

    @Column(name = "registro_facturacion", nullable = false)
    private Long registroFacturacion;


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
         return fechaInicio.toString();
    }
    public void setFechaInicio(String str_date)  {
            Timestamp nuevaFechaInicio;
            nuevaFechaInicio= Util.convertStringToTimestamp(str_date);
            this.fechaInicio = nuevaFechaInicio;

    }

    public String getFechaAprobacion() {
        return fechaAprobacion.toString();
    }

    public void setFechaAprobacion(String str_date) {
        Timestamp nuevaFechaAprobacion;
        nuevaFechaAprobacion= Util.convertStringToTimestamp(str_date);
        this.fechaAprobacion = nuevaFechaAprobacion;
    }

    public String getFechaEjecucion() {
        return fechaEjecucion.toString();
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
        return operador;
    }

    public void setOperador(Long operador) {
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
