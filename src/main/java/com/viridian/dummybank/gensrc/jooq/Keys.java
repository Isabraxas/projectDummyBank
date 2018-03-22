/*
 * This file is generated by jOOQ.
*/
package com.viridian.dummybank.gensrc.jooq;


import com.viridian.dummybank.gensrc.jooq.tables.Autorizacion;
import com.viridian.dummybank.gensrc.jooq.tables.Beneficiario;
import com.viridian.dummybank.gensrc.jooq.tables.Cliente;
import com.viridian.dummybank.gensrc.jooq.tables.ClienteBeneficiario;
import com.viridian.dummybank.gensrc.jooq.tables.Cuenta;
import com.viridian.dummybank.gensrc.jooq.tables.Estatus;
import com.viridian.dummybank.gensrc.jooq.tables.Metodo;
import com.viridian.dummybank.gensrc.jooq.tables.Operacion;
import com.viridian.dummybank.gensrc.jooq.tables.Operador;
import com.viridian.dummybank.gensrc.jooq.tables.Persona;
import com.viridian.dummybank.gensrc.jooq.tables.PersonaJuridica;
import com.viridian.dummybank.gensrc.jooq.tables.PersonaNatural;
import com.viridian.dummybank.gensrc.jooq.tables.Transaccion;
import com.viridian.dummybank.gensrc.jooq.tables.records.AutorizacionRecord;
import com.viridian.dummybank.gensrc.jooq.tables.records.BeneficiarioRecord;
import com.viridian.dummybank.gensrc.jooq.tables.records.ClienteBeneficiarioRecord;
import com.viridian.dummybank.gensrc.jooq.tables.records.ClienteRecord;
import com.viridian.dummybank.gensrc.jooq.tables.records.CuentaRecord;
import com.viridian.dummybank.gensrc.jooq.tables.records.EstatusRecord;
import com.viridian.dummybank.gensrc.jooq.tables.records.MetodoRecord;
import com.viridian.dummybank.gensrc.jooq.tables.records.OperacionRecord;
import com.viridian.dummybank.gensrc.jooq.tables.records.OperadorRecord;
import com.viridian.dummybank.gensrc.jooq.tables.records.PersonaJuridicaRecord;
import com.viridian.dummybank.gensrc.jooq.tables.records.PersonaNaturalRecord;
import com.viridian.dummybank.gensrc.jooq.tables.records.PersonaRecord;
import com.viridian.dummybank.gensrc.jooq.tables.records.TransaccionRecord;

import javax.annotation.Generated;

import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.UniqueKey;
import org.jooq.impl.Internal;


/**
 * A class modelling foreign key relationships and constraints of tables of 
 * the <code>viridianbank</code> schema.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.10.5"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Keys {

    // -------------------------------------------------------------------------
    // IDENTITY definitions
    // -------------------------------------------------------------------------

    public static final Identity<AutorizacionRecord, Long> IDENTITY_AUTORIZACION = Identities0.IDENTITY_AUTORIZACION;
    public static final Identity<BeneficiarioRecord, Long> IDENTITY_BENEFICIARIO = Identities0.IDENTITY_BENEFICIARIO;
    public static final Identity<ClienteRecord, Long> IDENTITY_CLIENTE = Identities0.IDENTITY_CLIENTE;
    public static final Identity<CuentaRecord, Long> IDENTITY_CUENTA = Identities0.IDENTITY_CUENTA;
    public static final Identity<EstatusRecord, Long> IDENTITY_ESTATUS = Identities0.IDENTITY_ESTATUS;
    public static final Identity<MetodoRecord, Long> IDENTITY_METODO = Identities0.IDENTITY_METODO;
    public static final Identity<OperacionRecord, Long> IDENTITY_OPERACION = Identities0.IDENTITY_OPERACION;
    public static final Identity<OperadorRecord, Long> IDENTITY_OPERADOR = Identities0.IDENTITY_OPERADOR;
    public static final Identity<PersonaRecord, Long> IDENTITY_PERSONA = Identities0.IDENTITY_PERSONA;
    public static final Identity<TransaccionRecord, Long> IDENTITY_TRANSACCION = Identities0.IDENTITY_TRANSACCION;

    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<AutorizacionRecord> KEY_AUTORIZACION_PRIMARY = UniqueKeys0.KEY_AUTORIZACION_PRIMARY;
    public static final UniqueKey<BeneficiarioRecord> KEY_BENEFICIARIO_PRIMARY = UniqueKeys0.KEY_BENEFICIARIO_PRIMARY;
    public static final UniqueKey<BeneficiarioRecord> KEY_BENEFICIARIO_NIT_CI = UniqueKeys0.KEY_BENEFICIARIO_NIT_CI;
    public static final UniqueKey<BeneficiarioRecord> KEY_BENEFICIARIO_NUMERO_CUENTA = UniqueKeys0.KEY_BENEFICIARIO_NUMERO_CUENTA;
    public static final UniqueKey<ClienteRecord> KEY_CLIENTE_PRIMARY = UniqueKeys0.KEY_CLIENTE_PRIMARY;
    public static final UniqueKey<ClienteBeneficiarioRecord> KEY_CLIENTE_BENEFICIARIO_PRIMARY = UniqueKeys0.KEY_CLIENTE_BENEFICIARIO_PRIMARY;
    public static final UniqueKey<CuentaRecord> KEY_CUENTA_PRIMARY = UniqueKeys0.KEY_CUENTA_PRIMARY;
    public static final UniqueKey<EstatusRecord> KEY_ESTATUS_PRIMARY = UniqueKeys0.KEY_ESTATUS_PRIMARY;
    public static final UniqueKey<MetodoRecord> KEY_METODO_PRIMARY = UniqueKeys0.KEY_METODO_PRIMARY;
    public static final UniqueKey<OperacionRecord> KEY_OPERACION_PRIMARY = UniqueKeys0.KEY_OPERACION_PRIMARY;
    public static final UniqueKey<OperadorRecord> KEY_OPERADOR_PRIMARY = UniqueKeys0.KEY_OPERADOR_PRIMARY;
    public static final UniqueKey<PersonaRecord> KEY_PERSONA_PRIMARY = UniqueKeys0.KEY_PERSONA_PRIMARY;
    public static final UniqueKey<PersonaJuridicaRecord> KEY_PERSONA_JURIDICA_PRIMARY = UniqueKeys0.KEY_PERSONA_JURIDICA_PRIMARY;
    public static final UniqueKey<PersonaNaturalRecord> KEY_PERSONA_NATURAL_PRIMARY = UniqueKeys0.KEY_PERSONA_NATURAL_PRIMARY;
    public static final UniqueKey<TransaccionRecord> KEY_TRANSACCION_PRIMARY = UniqueKeys0.KEY_TRANSACCION_PRIMARY;

    // -------------------------------------------------------------------------
    // FOREIGN KEY definitions
    // -------------------------------------------------------------------------

    public static final ForeignKey<ClienteBeneficiarioRecord, ClienteRecord> CLIENTE_BENEFICIARIO_IBFK_1 = ForeignKeys0.CLIENTE_BENEFICIARIO_IBFK_1;
    public static final ForeignKey<ClienteBeneficiarioRecord, BeneficiarioRecord> CLIENTE_BENEFICIARIO_IBFK_2 = ForeignKeys0.CLIENTE_BENEFICIARIO_IBFK_2;
    public static final ForeignKey<CuentaRecord, ClienteRecord> CLIENTE_ID_FK0 = ForeignKeys0.CLIENTE_ID_FK0;
    public static final ForeignKey<PersonaNaturalRecord, PersonaRecord> PERSONA_NATURAL_IBFK_1 = ForeignKeys0.PERSONA_NATURAL_IBFK_1;

    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class Identities0 {
        public static Identity<AutorizacionRecord, Long> IDENTITY_AUTORIZACION = Internal.createIdentity(Autorizacion.AUTORIZACION, Autorizacion.AUTORIZACION.ID_AUTORIZACION);
        public static Identity<BeneficiarioRecord, Long> IDENTITY_BENEFICIARIO = Internal.createIdentity(Beneficiario.BENEFICIARIO, Beneficiario.BENEFICIARIO.ID_BENEFICIARIO);
        public static Identity<ClienteRecord, Long> IDENTITY_CLIENTE = Internal.createIdentity(Cliente.CLIENTE, Cliente.CLIENTE.ID_CLIENTE);
        public static Identity<CuentaRecord, Long> IDENTITY_CUENTA = Internal.createIdentity(Cuenta.CUENTA, Cuenta.CUENTA.ID_CUENTA);
        public static Identity<EstatusRecord, Long> IDENTITY_ESTATUS = Internal.createIdentity(Estatus.ESTATUS, Estatus.ESTATUS.ID_ESTATUS);
        public static Identity<MetodoRecord, Long> IDENTITY_METODO = Internal.createIdentity(Metodo.METODO, Metodo.METODO.ID_METODO);
        public static Identity<OperacionRecord, Long> IDENTITY_OPERACION = Internal.createIdentity(Operacion.OPERACION, Operacion.OPERACION.ID_OPERACION);
        public static Identity<OperadorRecord, Long> IDENTITY_OPERADOR = Internal.createIdentity(Operador.OPERADOR, Operador.OPERADOR.ID_OPERADOR);
        public static Identity<PersonaRecord, Long> IDENTITY_PERSONA = Internal.createIdentity(Persona.PERSONA, Persona.PERSONA.ID_PERSONA);
        public static Identity<TransaccionRecord, Long> IDENTITY_TRANSACCION = Internal.createIdentity(Transaccion.TRANSACCION, Transaccion.TRANSACCION.ID_TRANSACCION);
    }

    private static class UniqueKeys0 {
        public static final UniqueKey<AutorizacionRecord> KEY_AUTORIZACION_PRIMARY = Internal.createUniqueKey(Autorizacion.AUTORIZACION, "KEY_Autorizacion_PRIMARY", Autorizacion.AUTORIZACION.ID_AUTORIZACION);
        public static final UniqueKey<BeneficiarioRecord> KEY_BENEFICIARIO_PRIMARY = Internal.createUniqueKey(Beneficiario.BENEFICIARIO, "KEY_Beneficiario_PRIMARY", Beneficiario.BENEFICIARIO.ID_BENEFICIARIO);
        public static final UniqueKey<BeneficiarioRecord> KEY_BENEFICIARIO_NIT_CI = Internal.createUniqueKey(Beneficiario.BENEFICIARIO, "KEY_Beneficiario_nit_ci", Beneficiario.BENEFICIARIO.NIT_CI);
        public static final UniqueKey<BeneficiarioRecord> KEY_BENEFICIARIO_NUMERO_CUENTA = Internal.createUniqueKey(Beneficiario.BENEFICIARIO, "KEY_Beneficiario_numero_cuenta", Beneficiario.BENEFICIARIO.NUMERO_CUENTA);
        public static final UniqueKey<ClienteRecord> KEY_CLIENTE_PRIMARY = Internal.createUniqueKey(Cliente.CLIENTE, "KEY_Cliente_PRIMARY", Cliente.CLIENTE.ID_CLIENTE);
        public static final UniqueKey<ClienteBeneficiarioRecord> KEY_CLIENTE_BENEFICIARIO_PRIMARY = Internal.createUniqueKey(ClienteBeneficiario.CLIENTE_BENEFICIARIO, "KEY_Cliente_Beneficiario_PRIMARY", ClienteBeneficiario.CLIENTE_BENEFICIARIO.CLIENTE_ID, ClienteBeneficiario.CLIENTE_BENEFICIARIO.BENEFICIARIO_ID);
        public static final UniqueKey<CuentaRecord> KEY_CUENTA_PRIMARY = Internal.createUniqueKey(Cuenta.CUENTA, "KEY_cuenta_PRIMARY", Cuenta.CUENTA.ID_CUENTA);
        public static final UniqueKey<EstatusRecord> KEY_ESTATUS_PRIMARY = Internal.createUniqueKey(Estatus.ESTATUS, "KEY_Estatus_PRIMARY", Estatus.ESTATUS.ID_ESTATUS);
        public static final UniqueKey<MetodoRecord> KEY_METODO_PRIMARY = Internal.createUniqueKey(Metodo.METODO, "KEY_Metodo_PRIMARY", Metodo.METODO.ID_METODO);
        public static final UniqueKey<OperacionRecord> KEY_OPERACION_PRIMARY = Internal.createUniqueKey(Operacion.OPERACION, "KEY_Operacion_PRIMARY", Operacion.OPERACION.ID_OPERACION);
        public static final UniqueKey<OperadorRecord> KEY_OPERADOR_PRIMARY = Internal.createUniqueKey(Operador.OPERADOR, "KEY_Operador_PRIMARY", Operador.OPERADOR.ID_OPERADOR);
        public static final UniqueKey<PersonaRecord> KEY_PERSONA_PRIMARY = Internal.createUniqueKey(Persona.PERSONA, "KEY_Persona_PRIMARY", Persona.PERSONA.ID_PERSONA);
        public static final UniqueKey<PersonaJuridicaRecord> KEY_PERSONA_JURIDICA_PRIMARY = Internal.createUniqueKey(PersonaJuridica.PERSONA_JURIDICA, "KEY_Persona_Juridica_PRIMARY", PersonaJuridica.PERSONA_JURIDICA.ID_CLIENTE);
        public static final UniqueKey<PersonaNaturalRecord> KEY_PERSONA_NATURAL_PRIMARY = Internal.createUniqueKey(PersonaNatural.PERSONA_NATURAL, "KEY_Persona_Natural_PRIMARY", PersonaNatural.PERSONA_NATURAL.ID_CLIENTE);
        public static final UniqueKey<TransaccionRecord> KEY_TRANSACCION_PRIMARY = Internal.createUniqueKey(Transaccion.TRANSACCION, "KEY_Transaccion_PRIMARY", Transaccion.TRANSACCION.ID_TRANSACCION);
    }

    private static class ForeignKeys0 {
        public static final ForeignKey<ClienteBeneficiarioRecord, ClienteRecord> CLIENTE_BENEFICIARIO_IBFK_1 = Internal.createForeignKey(com.viridian.dummybank.gensrc.jooq.Keys.KEY_CLIENTE_PRIMARY, ClienteBeneficiario.CLIENTE_BENEFICIARIO, "Cliente_Beneficiario_ibfk_1", ClienteBeneficiario.CLIENTE_BENEFICIARIO.CLIENTE_ID);
        public static final ForeignKey<ClienteBeneficiarioRecord, BeneficiarioRecord> CLIENTE_BENEFICIARIO_IBFK_2 = Internal.createForeignKey(com.viridian.dummybank.gensrc.jooq.Keys.KEY_BENEFICIARIO_PRIMARY, ClienteBeneficiario.CLIENTE_BENEFICIARIO, "Cliente_Beneficiario_ibfk_2", ClienteBeneficiario.CLIENTE_BENEFICIARIO.BENEFICIARIO_ID);
        public static final ForeignKey<CuentaRecord, ClienteRecord> CLIENTE_ID_FK0 = Internal.createForeignKey(com.viridian.dummybank.gensrc.jooq.Keys.KEY_CLIENTE_PRIMARY, Cuenta.CUENTA, "cliente_id_fk0", Cuenta.CUENTA.CLIENTE_ID);
        public static final ForeignKey<PersonaNaturalRecord, PersonaRecord> PERSONA_NATURAL_IBFK_1 = Internal.createForeignKey(com.viridian.dummybank.gensrc.jooq.Keys.KEY_PERSONA_PRIMARY, PersonaNatural.PERSONA_NATURAL, "Persona_Natural_ibfk_1", PersonaNatural.PERSONA_NATURAL.PERSONA_ID);
    }
}