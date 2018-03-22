/*
 * This file is generated by jOOQ.
*/
package com.viridian.dummybank.gensrc.jooq.tables;


import com.viridian.dummybank.gensrc.jooq.Indexes;
import com.viridian.dummybank.gensrc.jooq.Keys;
import com.viridian.dummybank.gensrc.jooq.Viridianbank;
import com.viridian.dummybank.gensrc.jooq.tables.records.OperadorRecord;

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
public class Operador extends TableImpl<OperadorRecord> {

    private static final long serialVersionUID = 1002674757;

    /**
     * The reference instance of <code>viridianbank.Operador</code>
     */
    public static final Operador OPERADOR = new Operador();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<OperadorRecord> getRecordType() {
        return OperadorRecord.class;
    }

    /**
     * The column <code>viridianbank.Operador.id_operador</code>.
     */
    public final TableField<OperadorRecord, Long> ID_OPERADOR = createField("id_operador", org.jooq.impl.SQLDataType.BIGINT.nullable(false).identity(true), this, "");

    /**
     * The column <code>viridianbank.Operador.nombre</code>.
     */
    public final TableField<OperadorRecord, String> NOMBRE = createField("nombre", org.jooq.impl.SQLDataType.VARCHAR(255).nullable(false), this, "");

    /**
     * The column <code>viridianbank.Operador.usuario_id</code>.
     */
    public final TableField<OperadorRecord, Long> USUARIO_ID = createField("usuario_id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * Create a <code>viridianbank.Operador</code> table reference
     */
    public Operador() {
        this(DSL.name("Operador"), null);
    }

    /**
     * Create an aliased <code>viridianbank.Operador</code> table reference
     */
    public Operador(String alias) {
        this(DSL.name(alias), OPERADOR);
    }

    /**
     * Create an aliased <code>viridianbank.Operador</code> table reference
     */
    public Operador(Name alias) {
        this(alias, OPERADOR);
    }

    private Operador(Name alias, Table<OperadorRecord> aliased) {
        this(alias, aliased, null);
    }

    private Operador(Name alias, Table<OperadorRecord> aliased, Field<?>[] parameters) {
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
        return Arrays.<Index>asList(Indexes.OPERADOR_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<OperadorRecord, Long> getIdentity() {
        return Keys.IDENTITY_OPERADOR;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<OperadorRecord> getPrimaryKey() {
        return Keys.KEY_OPERADOR_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<OperadorRecord>> getKeys() {
        return Arrays.<UniqueKey<OperadorRecord>>asList(Keys.KEY_OPERADOR_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Operador as(String alias) {
        return new Operador(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Operador as(Name alias) {
        return new Operador(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Operador rename(String name) {
        return new Operador(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Operador rename(Name name) {
        return new Operador(name, null);
    }
}