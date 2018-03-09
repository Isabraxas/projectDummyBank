package com.viridian.dummybank.rest.model;

import com.viridian.dummybank.model.Cuenta;

import java.sql.Date;
import java.util.List;

/**
 * Created by marcelo on 08-03-18
 */
public class ProductoBancarioClientePJ {
    // cliente
    private Long idCliente;            // clave para Cliente y para Persona_Natural
    //private String tipo;

    private String estado;

    // persona juridica
    private String nombreRazon;
    private Long nit;
    private String registroFundaempresa;

    // persona
    private Long idPersona;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String apellidoCasado;
    private String nombres;
    private String documentoIdentidad;
    private Long numeroDocumento;
    private Date fechaNacimiento;
    private String lugarNacimiento;
    private String nacionalidad;
    private String domicilio;
    private String domicilioTrabajo;
    private String telefono;
    private String email;
    private String estadoCivil;
    private String profesion;
    private String caracterLegal;
    private String nombrePadre;
    private String nombreMadre;
    private String nombreConyuge;

    private List<Cuenta> cuentas;

    public ProductoBancarioClientePJ() {
    }

    public ProductoBancarioClientePJ(Long idCliente, /*String tipo,*/String estado, String nombreRazon, Long nit, String registroFundaempresa, Long idPersona, String apellidoPaterno, String apellidoMaterno, String apellidoCasado, String nombres, String documentoIdentidad, Long numeroDocumento, Date fechaNacimiento, String lugarNacimiento, String nacionalidad, String domicilio, String domicilioTrabajo, String telefono, String email, String estadoCivil, String profesion, String caracterLegal, String nombrePadre, String nombreMadre, String nombreConyuge, List<Cuenta> cuentas) {
        this.idCliente = idCliente;
        //this.tipo = tipo;
        this.estado = estado;
        this.nombreRazon = nombreRazon;
        this.nit = nit;
        this.registroFundaempresa = registroFundaempresa;
        this.idPersona = idPersona;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.apellidoCasado = apellidoCasado;
        this.nombres = nombres;
        this.documentoIdentidad = documentoIdentidad;
        this.numeroDocumento = numeroDocumento;
        this.fechaNacimiento = fechaNacimiento;
        this.lugarNacimiento = lugarNacimiento;
        this.nacionalidad = nacionalidad;
        this.domicilio = domicilio;
        this.domicilioTrabajo = domicilioTrabajo;
        this.telefono = telefono;
        this.email = email;
        this.estadoCivil = estadoCivil;
        this.profesion = profesion;
        this.caracterLegal = caracterLegal;
        this.nombrePadre = nombrePadre;
        this.nombreMadre = nombreMadre;
        this.nombreConyuge = nombreConyuge;
        this.cuentas = cuentas;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }
/*
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
*/

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado= estado;
    }

    public String getNombreRazon() {
        return nombreRazon;
    }

    public void setNombreRazon(String nombreRazon) {
        this.nombreRazon = nombreRazon;
    }

    public Long getNit() {
        return nit;
    }

    public void setNit(Long nit) {
        this.nit = nit;
    }

    public String getRegistroFundaempresa() {
        return registroFundaempresa;
    }

    public void setRegistroFundaempresa(String registroFundaempresa) {
        this.registroFundaempresa = registroFundaempresa;
    }

    public Long getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Long idPersona) {
        this.idPersona = idPersona;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getApellidoCasado() {
        return apellidoCasado;
    }

    public void setApellidoCasado(String apellidoCasado) {
        this.apellidoCasado = apellidoCasado;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getDocumentoIdentidad() {
        return documentoIdentidad;
    }

    public void setDocumentoIdentidad(String documentoIdentidad) {
        this.documentoIdentidad = documentoIdentidad;
    }

    public Long getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(Long numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getLugarNacimiento() {
        return lugarNacimiento;
    }

    public void setLugarNacimiento(String lugarNacimiento) {
        this.lugarNacimiento = lugarNacimiento;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getDomicilioTrabajo() {
        return domicilioTrabajo;
    }

    public void setDomicilioTrabajo(String domicilioTrabajo) {
        this.domicilioTrabajo = domicilioTrabajo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public String getCaracterLegal() {
        return caracterLegal;
    }

    public void setCaracterLegal(String caracterLegal) {
        this.caracterLegal = caracterLegal;
    }

    public String getNombrePadre() {
        return nombrePadre;
    }

    public void setNombrePadre(String nombrePadre) {
        this.nombrePadre = nombrePadre;
    }

    public String getNombreMadre() {
        return nombreMadre;
    }

    public void setNombreMadre(String nombreMadre) {
        this.nombreMadre = nombreMadre;
    }

    public String getNombreConyuge() {
        return nombreConyuge;
    }

    public void setNombreConyuge(String nombreConyuge) {
        this.nombreConyuge = nombreConyuge;
    }

    public List<Cuenta> getCuentas() {
        return cuentas;
    }

    public void setCuentas(List<Cuenta> cuentas) {
        this.cuentas = cuentas;
    }
}
