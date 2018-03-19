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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Catalog;
import org.jooq.Table;
import org.jooq.impl.SchemaImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.10.5"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Viridianbank extends SchemaImpl {

    private static final long serialVersionUID = 1316457453;

    /**
     * The reference instance of <code>viridianbank</code>
     */
    public static final Viridianbank VIRIDIANBANK = new Viridianbank();

    /**
     * The table <code>viridianbank.Autorizacion</code>.
     */
    public final Autorizacion AUTORIZACION = com.viridian.dummybank.gensrc.jooq.tables.Autorizacion.AUTORIZACION;

    /**
     * The table <code>viridianbank.Beneficiario</code>.
     */
    public final Beneficiario BENEFICIARIO = com.viridian.dummybank.gensrc.jooq.tables.Beneficiario.BENEFICIARIO;

    /**
     * The table <code>viridianbank.Cliente</code>.
     */
    public final Cliente CLIENTE = com.viridian.dummybank.gensrc.jooq.tables.Cliente.CLIENTE;

    /**
     * The table <code>viridianbank.Cliente_Beneficiario</code>.
     */
    public final ClienteBeneficiario CLIENTE_BENEFICIARIO = com.viridian.dummybank.gensrc.jooq.tables.ClienteBeneficiario.CLIENTE_BENEFICIARIO;

    /**
     * The table <code>viridianbank.cuenta</code>.
     */
    public final Cuenta CUENTA = com.viridian.dummybank.gensrc.jooq.tables.Cuenta.CUENTA;

    /**
     * The table <code>viridianbank.Estatus</code>.
     */
    public final Estatus ESTATUS = com.viridian.dummybank.gensrc.jooq.tables.Estatus.ESTATUS;

    /**
     * The table <code>viridianbank.Metodo</code>.
     */
    public final Metodo METODO = com.viridian.dummybank.gensrc.jooq.tables.Metodo.METODO;

    /**
     * The table <code>viridianbank.Operacion</code>.
     */
    public final Operacion OPERACION = com.viridian.dummybank.gensrc.jooq.tables.Operacion.OPERACION;

    /**
     * The table <code>viridianbank.Operador</code>.
     */
    public final Operador OPERADOR = com.viridian.dummybank.gensrc.jooq.tables.Operador.OPERADOR;

    /**
     * The table <code>viridianbank.Persona</code>.
     */
    public final Persona PERSONA = com.viridian.dummybank.gensrc.jooq.tables.Persona.PERSONA;

    /**
     * The table <code>viridianbank.Persona_Juridica</code>.
     */
    public final PersonaJuridica PERSONA_JURIDICA = com.viridian.dummybank.gensrc.jooq.tables.PersonaJuridica.PERSONA_JURIDICA;

    /**
     * The table <code>viridianbank.Persona_Natural</code>.
     */
    public final PersonaNatural PERSONA_NATURAL = com.viridian.dummybank.gensrc.jooq.tables.PersonaNatural.PERSONA_NATURAL;

    /**
     * The table <code>viridianbank.Transaccion</code>.
     */
    public final Transaccion TRANSACCION = com.viridian.dummybank.gensrc.jooq.tables.Transaccion.TRANSACCION;

    /**
     * No further instances allowed
     */
    private Viridianbank() {
        super("viridianbank", null);
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public Catalog getCatalog() {
        return DefaultCatalog.DEFAULT_CATALOG;
    }

    @Override
    public final List<Table<?>> getTables() {
        List result = new ArrayList();
        result.addAll(getTables0());
        return result;
    }

    private final List<Table<?>> getTables0() {
        return Arrays.<Table<?>>asList(
            Autorizacion.AUTORIZACION,
            Beneficiario.BENEFICIARIO,
            Cliente.CLIENTE,
            ClienteBeneficiario.CLIENTE_BENEFICIARIO,
            Cuenta.CUENTA,
            Estatus.ESTATUS,
            Metodo.METODO,
            Operacion.OPERACION,
            Operador.OPERADOR,
            Persona.PERSONA,
            PersonaJuridica.PERSONA_JURIDICA,
            PersonaNatural.PERSONA_NATURAL,
            Transaccion.TRANSACCION);
    }
}
