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

import javax.annotation.Generated;

import org.jooq.Index;
import org.jooq.OrderField;
import org.jooq.impl.Internal;


/**
 * A class modelling indexes of tables of the <code>viridianbank</code> schema.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.10.5"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Indexes {

    // -------------------------------------------------------------------------
    // INDEX definitions
    // -------------------------------------------------------------------------

    public static final Index AUTORIZACION_PRIMARY = Indexes0.AUTORIZACION_PRIMARY;
    public static final Index BENEFICIARIO_NIT_CI = Indexes0.BENEFICIARIO_NIT_CI;
    public static final Index BENEFICIARIO_NUMERO_CUENTA = Indexes0.BENEFICIARIO_NUMERO_CUENTA;
    public static final Index BENEFICIARIO_PRIMARY = Indexes0.BENEFICIARIO_PRIMARY;
    public static final Index CLIENTE_PRIMARY = Indexes0.CLIENTE_PRIMARY;
    public static final Index CLIENTE_BENEFICIARIO_BENEFICIARIO_ID = Indexes0.CLIENTE_BENEFICIARIO_BENEFICIARIO_ID;
    public static final Index CLIENTE_BENEFICIARIO_PRIMARY = Indexes0.CLIENTE_BENEFICIARIO_PRIMARY;
    public static final Index CUENTA_CLIENTE_ID_FK0 = Indexes0.CUENTA_CLIENTE_ID_FK0;
    public static final Index CUENTA_PRIMARY = Indexes0.CUENTA_PRIMARY;
    public static final Index ESTATUS_PRIMARY = Indexes0.ESTATUS_PRIMARY;
    public static final Index METODO_PRIMARY = Indexes0.METODO_PRIMARY;
    public static final Index OPERACION_PRIMARY = Indexes0.OPERACION_PRIMARY;
    public static final Index OPERADOR_PRIMARY = Indexes0.OPERADOR_PRIMARY;
    public static final Index PERSONA_PRIMARY = Indexes0.PERSONA_PRIMARY;
    public static final Index PERSONA_JURIDICA_PRIMARY = Indexes0.PERSONA_JURIDICA_PRIMARY;
    public static final Index PERSONA_NATURAL_PERSONA_ID = Indexes0.PERSONA_NATURAL_PERSONA_ID;
    public static final Index PERSONA_NATURAL_PRIMARY = Indexes0.PERSONA_NATURAL_PRIMARY;
    public static final Index TRANSACCION_PRIMARY = Indexes0.TRANSACCION_PRIMARY;

    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class Indexes0 {
        public static Index AUTORIZACION_PRIMARY = Internal.createIndex("PRIMARY", Autorizacion.AUTORIZACION, new OrderField[] { Autorizacion.AUTORIZACION.ID_AUTORIZACION }, true);
        public static Index BENEFICIARIO_NIT_CI = Internal.createIndex("nit_ci", Beneficiario.BENEFICIARIO, new OrderField[] { Beneficiario.BENEFICIARIO.NIT_CI }, true);
        public static Index BENEFICIARIO_NUMERO_CUENTA = Internal.createIndex("numero_cuenta", Beneficiario.BENEFICIARIO, new OrderField[] { Beneficiario.BENEFICIARIO.NUMERO_CUENTA }, true);
        public static Index BENEFICIARIO_PRIMARY = Internal.createIndex("PRIMARY", Beneficiario.BENEFICIARIO, new OrderField[] { Beneficiario.BENEFICIARIO.ID_BENEFICIARIO }, true);
        public static Index CLIENTE_PRIMARY = Internal.createIndex("PRIMARY", Cliente.CLIENTE, new OrderField[] { Cliente.CLIENTE.ID_CLIENTE }, true);
        public static Index CLIENTE_BENEFICIARIO_BENEFICIARIO_ID = Internal.createIndex("beneficiario_id", ClienteBeneficiario.CLIENTE_BENEFICIARIO, new OrderField[] { ClienteBeneficiario.CLIENTE_BENEFICIARIO.BENEFICIARIO_ID }, false);
        public static Index CLIENTE_BENEFICIARIO_PRIMARY = Internal.createIndex("PRIMARY", ClienteBeneficiario.CLIENTE_BENEFICIARIO, new OrderField[] { ClienteBeneficiario.CLIENTE_BENEFICIARIO.CLIENTE_ID, ClienteBeneficiario.CLIENTE_BENEFICIARIO.BENEFICIARIO_ID }, true);
        public static Index CUENTA_CLIENTE_ID_FK0 = Internal.createIndex("cliente_id_fk0", Cuenta.CUENTA, new OrderField[] { Cuenta.CUENTA.CLIENTE_ID }, false);
        public static Index CUENTA_PRIMARY = Internal.createIndex("PRIMARY", Cuenta.CUENTA, new OrderField[] { Cuenta.CUENTA.ID_CUENTA }, true);
        public static Index ESTATUS_PRIMARY = Internal.createIndex("PRIMARY", Estatus.ESTATUS, new OrderField[] { Estatus.ESTATUS.ID_ESTATUS }, true);
        public static Index METODO_PRIMARY = Internal.createIndex("PRIMARY", Metodo.METODO, new OrderField[] { Metodo.METODO.ID_METODO }, true);
        public static Index OPERACION_PRIMARY = Internal.createIndex("PRIMARY", Operacion.OPERACION, new OrderField[] { Operacion.OPERACION.ID_OPERACION }, true);
        public static Index OPERADOR_PRIMARY = Internal.createIndex("PRIMARY", Operador.OPERADOR, new OrderField[] { Operador.OPERADOR.ID_OPERADOR }, true);
        public static Index PERSONA_PRIMARY = Internal.createIndex("PRIMARY", Persona.PERSONA, new OrderField[] { Persona.PERSONA.ID_PERSONA }, true);
        public static Index PERSONA_JURIDICA_PRIMARY = Internal.createIndex("PRIMARY", PersonaJuridica.PERSONA_JURIDICA, new OrderField[] { PersonaJuridica.PERSONA_JURIDICA.ID_CLIENTE }, true);
        public static Index PERSONA_NATURAL_PERSONA_ID = Internal.createIndex("persona_id", PersonaNatural.PERSONA_NATURAL, new OrderField[] { PersonaNatural.PERSONA_NATURAL.PERSONA_ID }, false);
        public static Index PERSONA_NATURAL_PRIMARY = Internal.createIndex("PRIMARY", PersonaNatural.PERSONA_NATURAL, new OrderField[] { PersonaNatural.PERSONA_NATURAL.ID_CLIENTE }, true);
        public static Index TRANSACCION_PRIMARY = Internal.createIndex("PRIMARY", Transaccion.TRANSACCION, new OrderField[] { Transaccion.TRANSACCION.ID_TRANSACCION }, true);
    }
}