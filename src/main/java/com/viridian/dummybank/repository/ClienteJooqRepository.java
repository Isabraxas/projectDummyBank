package com.viridian.dummybank.repository;

import com.viridian.dummybank.error.ErrorNoEncontrado;
import com.viridian.dummybank.error.NoEncontradoRestException;
import com.viridian.dummybank.gensrc.jooq.tables.records.ClienteRecord;
import com.viridian.dummybank.gensrc.jooq.tables.records.CuentaRecord;
import com.viridian.dummybank.gensrc.jooq.tables.records.PersonaJuridicaRecord;
import com.viridian.dummybank.gensrc.jooq.tables.records.PersonaRecord;
import com.viridian.dummybank.model.Cliente;
import com.viridian.dummybank.model.Cuenta;
import com.viridian.dummybank.model.persona.Persona;
import com.viridian.dummybank.rest.model.ProductoBancarioClientePJ;
import com.viridian.dummybank.rest.model.ProductoBancarioClientePN;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.Null;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.viridian.dummybank.gensrc.jooq.tables.Cliente.CLIENTE;
import static com.viridian.dummybank.gensrc.jooq.tables.Cuenta.CUENTA;
import static com.viridian.dummybank.gensrc.jooq.tables.Persona.PERSONA;
import static com.viridian.dummybank.gensrc.jooq.tables.PersonaJuridica.PERSONA_JURIDICA;
import static com.viridian.dummybank.gensrc.jooq.tables.PersonaNatural.PERSONA_NATURAL;

/**
 * Created by marcelo on 19-03-18
 */
@Repository
public class ClienteJooqRepository {
    String user = "root";
    String pass = "password";
    String url = "jdbc:mysql://localhost:3306/viridianbank";

    DSLContext dslContext;

    public ProductoBancarioClientePN getClienteNatById(Long id){
        ProductoBancarioClientePN prod = new ProductoBancarioClientePN();
        //Cliente cliente = new Cliente();
        //Persona persona = new Persona();
        // OBTENER INFORMACION DEL CLIENTE Y LA PERSONA NATURAL
        try(Connection conn = DriverManager.getConnection(url, user, pass)){
            dslContext = DSL.using(conn, SQLDialect.MYSQL);
            Record record =
                    dslContext.
                            select(PERSONA.fields()).
                            select(CLIENTE.fields()).
                            from(CLIENTE)
                            .leftJoin(PERSONA_NATURAL).on(CLIENTE.ID_CLIENTE.eq(PERSONA_NATURAL.ID_CLIENTE))
                            .leftJoin(PERSONA).on(PERSONA_NATURAL.PERSONA_ID.eq(PERSONA.ID_PERSONA))
                            .where(CLIENTE.ID_CLIENTE.equal(id)).fetchOne();
            ClienteRecord clienteRecord = record.into(CLIENTE);
            PersonaRecord personaRecord = record.into(PERSONA);

            // cliente
            prod.setIdCliente(clienteRecord.getIdCliente());
            //cliente.setTipo(clienteRecord.getTipo());

            // persona
            prod.setIdPersona(personaRecord.getIdPersona());
            prod.setApellidoMaterno(personaRecord.getApellidoMaterno());
            prod.setApellidoPaterno(personaRecord.getApellidoPaterno());
            prod.setApellidoCasado(personaRecord.getApellidoCasado());
            prod.setNombres(personaRecord.getNombre());
            prod.setNombreConyuge(personaRecord.getNombreConyuge());
            prod.setNombreMadre(personaRecord.getNombreMadre());
            prod.setNombrePadre(personaRecord.getNombrePadre());
            prod.setProfesion(personaRecord.getProfesion());
            prod.setEstadoCivil(personaRecord.getEstadoCivil());
            prod.setEmail(personaRecord.getEmail());
            prod.setTelefono(personaRecord.getTelefono());
            prod.setDomicilioTrabajo(personaRecord.getDomicilioTrabajo());
            prod.setDomicilio(personaRecord.getDomicilio());
            prod.setNacionalidad(personaRecord.getNacionalidad());
            prod.setLugarNacimiento(personaRecord.getLugarNacimiento());
            prod.setFechaNacimiento(Date.valueOf(personaRecord.getFechaNacimiento()));
            prod.setNumeroDocumento(personaRecord.getIdPersona());
            prod.setDocumentoIdentidad(personaRecord.getDocumentoIdentidad());
            prod.setCaracterLegal(personaRecord.getCaracterLegal());

            /*
            select P.*
            from Cliente C
            left join Persona_Natural PN on C.id_cliente = PN.id_cliente
            left join Persona P on PN.persona_id = P.id_persona
            where C.id_cliente = 7;
            * */
            // OBTENER LAS CUETNAS ASOCIADAS AL CLIENTE
            Result<Record> result = dslContext.select().from(CUENTA).where(CUENTA.CLIENTE_ID.eq(id)).fetch();
            List<Cuenta> cuentas = new ArrayList<>();
            for(Record r :result){
                Cuenta cuenta = new Cuenta();
                CuentaRecord cuentaRecord = r.into(CUENTA);
                cuenta.setIdCuenta(cuentaRecord.getIdCuenta());
                cuenta.setNumeroCuenta(cuentaRecord.getNumeroCuenta());
                cuenta.setSaldo(BigDecimal.valueOf(cuentaRecord.getSaldo()));
                cuenta.setTipo(cuentaRecord.getTipo());
                cuentas.add(cuenta);
            }
            prod.setCuentas(cuentas);

            // ESTADO
            prod.setEstado("successful");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return prod;
    }

    public ProductoBancarioClientePJ getClienteJurById(Long id){
        ProductoBancarioClientePJ prod = new ProductoBancarioClientePJ();
        //Cliente cliente = new Cliente();
        //Persona persona = new Persona();
        // OBTENER INFORMACION DEL CLIENTE Y LA PERSONA NATURAL
        try(Connection conn = DriverManager.getConnection(url, user, pass)){
            dslContext = DSL.using(conn, SQLDialect.MYSQL);
            Record record =
                    dslContext.
                            select(PERSONA.fields()).
                            select(CLIENTE.fields()).
                            select(PERSONA_JURIDICA.fields()).
                            from(CLIENTE)
                            .leftJoin(PERSONA_JURIDICA).on(CLIENTE.ID_CLIENTE.eq(PERSONA_JURIDICA.ID_CLIENTE))
                            .leftJoin(PERSONA).on(PERSONA_JURIDICA.REPRESENTANTE_LEGAL.eq(PERSONA.ID_PERSONA))
                            .where(CLIENTE.ID_CLIENTE.equal(id)).fetchOne();
            ClienteRecord clienteRecord = record.into(CLIENTE);
            PersonaRecord personaRecord = record.into(PERSONA);
            PersonaJuridicaRecord personaJuridicaRecord = record.into(PERSONA_JURIDICA);

            // cliente
            prod.setIdCliente(clienteRecord.getIdCliente());
            //cliente.setTipo(clienteRecord.getTipo());

            // persona juridica
            prod.setRegistroFundaempresa(personaJuridicaRecord.getRegistroFundaempresa());
            prod.setNit(personaJuridicaRecord.getNit());
            prod.setNombreRazon(personaJuridicaRecord.getNombreRazon());

            // persona
            prod.setIdPersona(personaRecord.getIdPersona());
            prod.setApellidoMaterno(personaRecord.getApellidoMaterno());
            prod.setApellidoPaterno(personaRecord.getApellidoPaterno());
            prod.setApellidoCasado(personaRecord.getApellidoCasado());
            prod.setNombres(personaRecord.getNombre());
            prod.setNombreConyuge(personaRecord.getNombreConyuge());
            prod.setNombreMadre(personaRecord.getNombreMadre());
            prod.setNombrePadre(personaRecord.getNombrePadre());
            prod.setProfesion(personaRecord.getProfesion());
            prod.setEstadoCivil(personaRecord.getEstadoCivil());
            prod.setEmail(personaRecord.getEmail());
            prod.setTelefono(personaRecord.getTelefono());
            prod.setDomicilioTrabajo(personaRecord.getDomicilioTrabajo());
            prod.setDomicilio(personaRecord.getDomicilio());
            prod.setNacionalidad(personaRecord.getNacionalidad());
            prod.setLugarNacimiento(personaRecord.getLugarNacimiento());
            prod.setFechaNacimiento(Date.valueOf(personaRecord.getFechaNacimiento()));
            prod.setNumeroDocumento(personaRecord.getIdPersona());
            prod.setDocumentoIdentidad(personaRecord.getDocumentoIdentidad());
            prod.setCaracterLegal(personaRecord.getCaracterLegal());

            /*
            select C.*,P*,PJ.*
            from Cliente C
            left join Persona_Juridica PJ on C.id_cliente = PJ.id_cliente
            left join Persona P on PJ.representante_legal = P.id_persona
            where C.id_cliente = 2;
            * */
            // OBTENER LAS CUETNAS ASOCIADAS AL CLIENTE
            Result<Record> result = dslContext.select().from(CUENTA).where(CUENTA.CLIENTE_ID.eq(id)).fetch();
            List<Cuenta> cuentas = new ArrayList<>();
            for(Record r :result){
                Cuenta cuenta = new Cuenta();
                CuentaRecord cuentaRecord = r.into(CUENTA);
                cuenta.setIdCuenta(cuentaRecord.getIdCuenta());
                cuenta.setNumeroCuenta(cuentaRecord.getNumeroCuenta());
                cuenta.setSaldo(BigDecimal.valueOf(cuentaRecord.getSaldo()));
                cuenta.setTipo(cuentaRecord.getTipo());
                cuentas.add(cuenta);
            }
            prod.setCuentas(cuentas);

            // ESTADO
            prod.setEstado("successful");
        }catch (SQLException e){
            //System.out.println(e.getClass().getName());
            System.out.println(e.getMessage());
        }catch (NullPointerException e){
            throw new NoEncontradoRestException(e.getMessage(),new ErrorNoEncontrado(id,"001","no se encontro al cliente en la bd", "Hemos encontrado un error intentelo mas tarde"));
        }
        return prod;
    }
}
