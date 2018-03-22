/*
 * This file is generated by jOOQ.
*/
package com.viridian.dummybank.gensrc.jooq.tables;


import com.viridian.dummybank.gensrc.jooq.Indexes;
import com.viridian.dummybank.gensrc.jooq.Keys;
import com.viridian.dummybank.gensrc.jooq.Viridianbank;
import com.viridian.dummybank.gensrc.jooq.tables.records.TransaccionRecord;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Identity;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;


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
public class Transaccion extends TableImpl<TransaccionRecord> {

    private static final long serialVersionUID = 1519460578;

    /**
     * The reference instance of <code>viridianbank.Transaccion</code>
     */
    public static final Transaccion TRANSACCION = new Transaccion();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<TransaccionRecord> getRecordType() {
        return TransaccionRecord.class;
    }

    /**
     * The column <code>viridianbank.Transaccion.id_transaccion</code>.
     */
    public final TableField<TransaccionRecord, Long> ID_TRANSACCION = createField("id_transaccion", org.jooq.impl.SQLDataType.BIGINT.nullable(false).identity(true), this, "");

    /**
     * The column <code>viridianbank.Transaccion.numero_cuenta</code>.
     */
    public final TableField<TransaccionRecord, Long> NUMERO_CUENTA = createField("numero_cuenta", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>viridianbank.Transaccion.fecha_inicio</code>.
     */
    public final TableField<TransaccionRecord, Timestamp> FECHA_INICIO = createField("fecha_inicio", org.jooq.impl.SQLDataType.TIMESTAMP.defaultValue(org.jooq.impl.DSL.field("CURRENT_TIMESTAMP", org.jooq.impl.SQLDataType.TIMESTAMP)), this, "");

    /**
     * The column <code>viridianbank.Transaccion.fecha_aprobacion</code>.
     */
    public final TableField<TransaccionRecord, Timestamp> FECHA_APROBACION = createField("fecha_aprobacion", org.jooq.impl.SQLDataType.TIMESTAMP, this, "");

    /**
     * The column <code>viridianbank.Transaccion.fecha_ejecucion</code>.
     */
    public final TableField<TransaccionRecord, Timestamp> FECHA_EJECUCION = createField("fecha_ejecucion", org.jooq.impl.SQLDataType.TIMESTAMP, this, "");

    /**
     * The column <code>viridianbank.Transaccion.numero_orden</code>.
     */
    public final TableField<TransaccionRecord, Long> NUMERO_ORDEN = createField("numero_orden", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>viridianbank.Transaccion.metodo_id</code>.
     */
    public final TableField<TransaccionRecord, Long> METODO_ID = createField("metodo_id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>viridianbank.Transaccion.estatus_id</code>.
     */
    public final TableField<TransaccionRecord, Long> ESTATUS_ID = createField("estatus_id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>viridianbank.Transaccion.autorizacion_id</code>.
     */
    public final TableField<TransaccionRecord, Long> AUTORIZACION_ID = createField("autorizacion_id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>viridianbank.Transaccion.operacion_id</code>.
     */
    public final TableField<TransaccionRecord, Long> OPERACION_ID = createField("operacion_id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>viridianbank.Transaccion.concepto_glosa</code>.
     */
    public final TableField<TransaccionRecord, String> CONCEPTO_GLOSA = createField("concepto_glosa", org.jooq.impl.SQLDataType.VARCHAR(255).nullable(false), this, "");

    /**
     * The column <code>viridianbank.Transaccion.monto</code>.
     */
    public final TableField<TransaccionRecord, Long> MONTO = createField("monto", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>viridianbank.Transaccion.moneda</code>.
     */
    public final TableField<TransaccionRecord, String> MONEDA = createField("moneda", org.jooq.impl.SQLDataType.VARCHAR(255).nullable(false), this, "");

    /**
     * The column <code>viridianbank.Transaccion.saldo</code>.
     */
    public final TableField<TransaccionRecord, Long> SALDO = createField("saldo", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>viridianbank.Transaccion.beneficiario_id</code>.
     */
    public final TableField<TransaccionRecord, Long> BENEFICIARIO_ID = createField("beneficiario_id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>viridianbank.Transaccion.operador_id</code>.
     */
    public final TableField<TransaccionRecord, Long> OPERADOR_ID = createField("operador_id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>viridianbank.Transaccion.regis_asfi</code>.
     */
    public final TableField<TransaccionRecord, Long> REGIS_ASFI = createField("regis_asfi", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>viridianbank.Transaccion.registro_facturacion</code>.
     */
    public final TableField<TransaccionRecord, Long> REGISTRO_FACTURACION = createField("registro_facturacion", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * Create a <code>viridianbank.Transaccion</code> table reference
     */
    public Transaccion() {
        this(DSL.name("Transaccion"), null);
    }

    /**
     * Create an aliased <code>viridianbank.Transaccion</code> table reference
     */
    public Transaccion(String alias) {
        this(DSL.name(alias), TRANSACCION);
    }

    /**
     * Create an aliased <code>viridianbank.Transaccion</code> table reference
     */
    public Transaccion(Name alias) {
        this(alias, TRANSACCION);
    }

    private Transaccion(Name alias, Table<TransaccionRecord> aliased) {
        this(alias, aliased, null);
    }

    private Transaccion(Name alias, Table<TransaccionRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, "");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return Viridianbank.VIRIDIANBANK;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.TRANSACCION_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<TransaccionRecord, Long> getIdentity() {
        return Keys.IDENTITY_TRANSACCION;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<TransaccionRecord> getPrimaryKey() {
        return Keys.KEY_TRANSACCION_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<TransaccionRecord>> getKeys() {
        return Arrays.<UniqueKey<TransaccionRecord>>asList(Keys.KEY_TRANSACCION_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Transaccion as(String alias) {
        return new Transaccion(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Transaccion as(Name alias) {
        return new Transaccion(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Transaccion rename(String name) {
        return new Transaccion(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Transaccion rename(Name name) {
        return new Transaccion(name, null);
    }
}