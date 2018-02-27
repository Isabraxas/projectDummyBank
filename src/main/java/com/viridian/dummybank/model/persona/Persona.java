package com.viridian.dummybank.model.persona;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

/**
 * Created by marcelo on 22-02-18
 */
@Entity
@Table(name = "Persona")
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_persona")
    private Long id;
    @Column(name = "apellido_paterno")
    private String apellidoPaterno;
    @Column(name = "apellido_materno")
    private String apellidoMaterno;
    @Column(name = "apellido_casado")
    private String apellidoCasado;
    @Column(name = "nombre")
    private String nombres;
    @Column(name = "documento_identidad")
    private String documentoIdentidad;
    @Column(name = "numero_documento")
    private Long numeroDocumento;
    @Column(name = "fecha_nacimiento")
    private Date fechaNacimiento;
    @Column(name = "lugar_nacimiento")
    private String lugarNacimiento;
    @Column(name = "nacionalidad")
    private String nacionalidad;
    @Column(name = "domicilio")
    private String domicilio;
    @Column(name = "domicilio_trabajo")
    private String domicilioTrabajo;
    @Column(name = "telefono")
    private String telefono;
    @Column(name = "email")
    private String email;
    @Column(name = "estado_civil")
    private String estadoCivil;
    @Column(name = "profesion")
    private String profesion;
    @Column(name = "caracter_legal")
    private String caracterLegal;
    @Column(name = "nombre_padre")
    private String nombrePadre;
    @Column(name = "nombre_madre")
    private String nombreMadre;
    @Column(name = "nombre_conyuge")
    private String nombreConyuge;
    //private Byte[] firma


    public Persona() {
    }

    public Persona(String apellidoPaterno, String apellidoMaterno, String apellidoCasado, String nombres, String documentoIdentidad, Long numeroDocumento, Date fechaNacimiento, String lugarNacimiento, String nacionalidad, String domicilio, String domicilioTrabajo, String telefono, String email, String estadoCivil, String profesion, String caracterLegal, String nombrePadre, String nombreMadre, String nombreConyuge) {
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
    }

    public Persona(String apellidoPaterno, String apellidoMaterno, String nombres, String documentoIdentidad, Long numeroDocumento, Date fechaNacimiento, String lugarNacimiento, String nacionalidad, String domicilio, String telefono, String email, String estadoCivil, String profesion, String caracterLegal, String nombrePadre, String nombreMadre) {
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;

        this.nombres = nombres;
        this.documentoIdentidad = documentoIdentidad;
        this.numeroDocumento = numeroDocumento;
        this.fechaNacimiento = fechaNacimiento;
        this.lugarNacimiento = lugarNacimiento;
        this.nacionalidad = nacionalidad;
        this.domicilio = domicilio;

        this.telefono = telefono;
        this.email = email;
        this.estadoCivil = estadoCivil;
        this.profesion = profesion;
        this.caracterLegal = caracterLegal;
        this.nombrePadre = nombrePadre;
        this.nombreMadre = nombreMadre;

    }

    @Override
    public String toString() {
        return "Persona{" +
                "id=" + id +
                ", apellidoPaterno='" + apellidoPaterno + '\'' +
                ", apellidoMaterno='" + apellidoMaterno + '\'' +
                ", apellidoCasado='" + apellidoCasado + '\'' +
                ", nombres='" + nombres + '\'' +
                ", documentoIdentidad='" + documentoIdentidad + '\'' +
                ", numeroDocumento=" + numeroDocumento +
                ", fechaNacimiento=" + fechaNacimiento +
                ", lugarNacimiento='" + lugarNacimiento + '\'' +
                ", nacionalidad='" + nacionalidad + '\'' +
                ", domicilio='" + domicilio + '\'' +
                ", domicilioTrabajo='" + domicilioTrabajo + '\'' +
                ", telefono='" + telefono + '\'' +
                ", email='" + email + '\'' +
                ", estadoCivil='" + estadoCivil + '\'' +
                ", profesion='" + profesion + '\'' +
                ", caracterLegal='" + caracterLegal + '\'' +
                ", nombrePadre='" + nombrePadre + '\'' +
                ", nombreMadre='" + nombreMadre + '\'' +
                ", nombreConyuge='" + nombreConyuge + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}
