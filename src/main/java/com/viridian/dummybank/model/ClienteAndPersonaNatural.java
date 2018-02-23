package com.viridian.dummybank.model;

import com.viridian.dummybank.model.persona.Persona;
import com.viridian.dummybank.model.persona.PersonaNatural;

import java.sql.Date;

/**
 * Created by marcelo on 23-02-18
 */
public class ClienteAndPersonaNatural {

    // cliente
    private Long id_cliente;            // clave para Cliente y para Persona_Natural
    private String tipo;

    // persona - persona natural
    private Long persona_id;            // clave para Persona
    private String apellido_paterno;
    private String apellido_materno;
    private String apellido_casado;
    private String nombres;
    private String documento_identidad;
    private Long numero_documento;
    private Date fecha_nacimiento;
    private String lugar_nacimiento;
    private String nacionalidad;
    private String domicilio;
    private String domicilio_trabajo;
    private String telefono;
    private String email;
    private String estado_civil;
    private String profesion;
    private String caracter_legal;
    private String nombre_padre;
    private String nombre_madre;
    private String nombre_conyuge;

    public ClienteAndPersonaNatural() {
    }

    public ClienteAndPersonaNatural(Cliente cliente, PersonaNatural persona){
        this.id_cliente = cliente.getId();
        this.tipo = cliente.getTipo();

        this.persona_id = persona.getPersona().getId();
        this.apellido_paterno = persona.getPersona().getApellidoPaterno();
        this.apellido_materno = persona.getPersona().getApellidoMaterno();
        this.apellido_casado = persona.getPersona().getApellidoCasado();
        this.nombres = persona.getPersona().getNombres();
        this.documento_identidad = persona.getPersona().getDocumentoIdentidad();
        this.numero_documento = persona.getPersona().getNumeroDocumento();
        this.fecha_nacimiento = persona.getPersona().getFechaNacimiento();
        this.lugar_nacimiento = persona.getPersona().getLugarNacimiento();
        this.nacionalidad = persona.getPersona().getNacionalidad();
        this.domicilio = persona.getPersona().getDomicilio();
        this.domicilio_trabajo = persona.getPersona().getDomicilioTrabajo();
        this.telefono = persona.getPersona().getTelefono();
        this.email = persona.getPersona().getEmail();
        this.estado_civil = persona.getPersona().getEstadoCivil();
        this.profesion = persona.getPersona().getProfesion();
        this.caracter_legal = persona.getPersona().getCaracterLegal();
        this.nombre_padre = persona.getPersona().getNombrePadre();
        this.nombre_madre = persona.getPersona().getNombreMadre();
    }

    public ClienteAndPersonaNatural(Long id_cliente, String tipo, Long persona_id, String apellido_paterno, String apellido_materno, String nombres, String documento_identidad, Long numero_documento, Date fecha_nacimiento, String lugar_nacimiento, String nacionalidad, String domicilio, String telefono, String email, String estado_civil, String profesion, String caracter_legal, String nombre_padre, String nombre_madre) {
        this.id_cliente = id_cliente;
        this.tipo = tipo;
        this.persona_id = persona_id;
        this.apellido_paterno = apellido_paterno;
        this.apellido_materno = apellido_materno;
        this.nombres = nombres;
        this.documento_identidad = documento_identidad;
        this.numero_documento = numero_documento;
        this.fecha_nacimiento = fecha_nacimiento;
        this.lugar_nacimiento = lugar_nacimiento;
        this.nacionalidad = nacionalidad;
        this.domicilio = domicilio;
        this.telefono = telefono;
        this.email = email;
        this.estado_civil = estado_civil;
        this.profesion = profesion;
        this.caracter_legal = caracter_legal;
        this.nombre_padre = nombre_padre;
        this.nombre_madre = nombre_madre;
    }

    public ClienteAndPersonaNatural(Long id_cliente, String tipo, Long persona_id, String apellido_paterno, String apellido_materno, String apellido_casado, String nombres, String documento_identidad, Long numero_documento, Date fecha_nacimiento, String lugar_nacimiento, String nacionalidad, String domicilio, String domicilio_trabajo, String telefono, String email, String estado_civil, String profesion, String caracter_legal, String nombre_padre, String nombre_madre, String nombre_conyuge) {
        this.id_cliente = id_cliente;
        this.tipo = tipo;
        this.persona_id = persona_id;
        this.apellido_paterno = apellido_paterno;
        this.apellido_materno = apellido_materno;
        this.apellido_casado = apellido_casado;
        this.nombres = nombres;
        this.documento_identidad = documento_identidad;
        this.numero_documento = numero_documento;
        this.fecha_nacimiento = fecha_nacimiento;
        this.lugar_nacimiento = lugar_nacimiento;
        this.nacionalidad = nacionalidad;
        this.domicilio = domicilio;
        this.domicilio_trabajo = domicilio_trabajo;
        this.telefono = telefono;
        this.email = email;
        this.estado_civil = estado_civil;
        this.profesion = profesion;
        this.caracter_legal = caracter_legal;
        this.nombre_padre = nombre_padre;
        this.nombre_madre = nombre_madre;
        this.nombre_conyuge = nombre_conyuge;
    }

    public Cliente getCliente(){
        Cliente cliente = new Cliente();
        cliente.setId(id_cliente);
        cliente.setTipo(tipo);
        return cliente;
    }

    public Persona getPersona(){
        Persona persona = new Persona();
        persona.setId(persona_id);
        persona.setApellidoCasado(apellido_casado);
        persona.setApellidoMaterno(apellido_materno);
        persona.setApellidoPaterno(apellido_paterno);
        persona.setNombres(nombres);
        persona.setDocumentoIdentidad(documento_identidad);
        persona.setNumeroDocumento(numero_documento);
        persona.setFechaNacimiento(fecha_nacimiento);
        persona.setLugarNacimiento(lugar_nacimiento);
        persona.setNacionalidad(nacionalidad);
        persona.setDomicilio(domicilio);
        persona.setDomicilioTrabajo(domicilio_trabajo);
        persona.setTelefono(telefono);
        persona.setEmail(email);
        persona.setEstadoCivil(estado_civil);
        persona.setProfesion(profesion);
        persona.setCaracterLegal(caracter_legal);
        persona.setNombrePadre(nombre_padre);
        persona.setNombreMadre(nombre_madre);
        persona.setNombreConyuge(nombre_conyuge);

        return persona;
    }

    @Override
    public String toString() {
        return "ClienteAndPersonaNatural{" +
                "id_cliente=" + id_cliente +
                ", tipo='" + tipo + '\'' +
                ", persona_id=" + persona_id +
                ", apellido_paterno='" + apellido_paterno + '\'' +
                ", apellido_materno='" + apellido_materno + '\'' +
                ", apellido_casado='" + apellido_casado + '\'' +
                ", nombres='" + nombres + '\'' +
                ", documento_identidad='" + documento_identidad + '\'' +
                ", numero_documento=" + numero_documento +
                ", fecha_nacimiento=" + fecha_nacimiento +
                ", lugar_nacimiento='" + lugar_nacimiento + '\'' +
                ", nacionalidad='" + nacionalidad + '\'' +
                ", domicilio='" + domicilio + '\'' +
                ", domicilio_trabajo='" + domicilio_trabajo + '\'' +
                ", telefono='" + telefono + '\'' +
                ", email='" + email + '\'' +
                ", estado_civil='" + estado_civil + '\'' +
                ", profesion='" + profesion + '\'' +
                ", caracter_legal='" + caracter_legal + '\'' +
                ", nombre_padre='" + nombre_padre + '\'' +
                ", nombre_madre='" + nombre_madre + '\'' +
                ", nombre_conyuge='" + nombre_conyuge + '\'' +
                '}';
    }

    public Long getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(Long id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Long getPersona_id() {
        return persona_id;
    }

    public void setPersona_id(Long persona_id) {
        this.persona_id = persona_id;
    }

    public String getApellido_paterno() {
        return apellido_paterno;
    }

    public void setApellido_paterno(String apellido_paterno) {
        this.apellido_paterno = apellido_paterno;
    }

    public String getApellido_materno() {
        return apellido_materno;
    }

    public void setApellido_materno(String apellido_materno) {
        this.apellido_materno = apellido_materno;
    }

    public String getApellido_casado() {
        return apellido_casado;
    }

    public void setApellido_casado(String apellido_casado) {
        this.apellido_casado = apellido_casado;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getDocumento_identidad() {
        return documento_identidad;
    }

    public void setDocumento_identidad(String documento_identidad) {
        this.documento_identidad = documento_identidad;
    }

    public Long getNumero_documento() {
        return numero_documento;
    }

    public void setNumero_documento(Long numero_documento) {
        this.numero_documento = numero_documento;
    }

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getLugar_nacimiento() {
        return lugar_nacimiento;
    }

    public void setLugar_nacimiento(String lugar_nacimiento) {
        this.lugar_nacimiento = lugar_nacimiento;
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

    public String getDomicilio_trabajo() {
        return domicilio_trabajo;
    }

    public void setDomicilio_trabajo(String domicilio_trabajo) {
        this.domicilio_trabajo = domicilio_trabajo;
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

    public String getEstado_civil() {
        return estado_civil;
    }

    public void setEstado_civil(String estado_civil) {
        this.estado_civil = estado_civil;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public String getCaracter_legal() {
        return caracter_legal;
    }

    public void setCaracter_legal(String caracter_legal) {
        this.caracter_legal = caracter_legal;
    }

    public String getNombre_padre() {
        return nombre_padre;
    }

    public void setNombre_padre(String nombre_padre) {
        this.nombre_padre = nombre_padre;
    }

    public String getNombre_madre() {
        return nombre_madre;
    }

    public void setNombre_madre(String nombre_madre) {
        this.nombre_madre = nombre_madre;
    }

    public String getNombre_conyuge() {
        return nombre_conyuge;
    }

    public void setNombre_conyuge(String nombre_conyuge) {
        this.nombre_conyuge = nombre_conyuge;
    }
}
