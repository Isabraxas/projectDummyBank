/*
 * This file is generated by jOOQ.
*/
package com.viridian.dummybank.gensrc.jooq.tables;


import com.viridian.dummybank.gensrc.jooq.Indexes;
import com.viridian.dummybank.gensrc.jooq.Keys;
import com.viridian.dummybank.gensrc.jooq.Viridianbank;
import com.viridian.dummybank.gensrc.jooq.tables.records.MetodoRecord;

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
public class Metodo extends TableImpl<MetodoRecord> {

    private static final long serialVersionUID = 956226253;

    /**
     * The reference instance of <code>viridianbank.Metodo</code>
     */
    public static final Metodo METODO = new Metodo();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<MetodoRecord> getRecordType() {
        return MetodoRecord.class;
    }

    /**
     * The column <code>viridianbank.Metodo.id_metodo</code>.
     */
    public final TableField<MetodoRecord, Long> ID_METODO = createField("id_metodo", org.jooq.impl.SQLDataType.BIGINT.nullable(false).identity(true), this, "");

    /**
     * The column <code>viridianbank.Metodo.descripcion</code>.
     */
    public final TableField<MetodoRecord, String> DESCRIPCION = createField("descripcion", org.jooq.impl.SQLDataType.VARCHAR(255).nullable(false), this, "");

    /**
     * Create a <code>viridianbank.Metodo</code> table reference
     */
    public Metodo() {
        this(DSL.name("Metodo"), null);
    }

    /**
     * Create an aliased <code>viridianbank.Metodo</code> table reference
     */
    public Metodo(String alias) {
        this(DSL.name(alias), METODO);
    }

    /**
     * Create an aliased <code>viridianbank.Metodo</code> table reference
     */
    public Metodo(Name alias) {
        this(alias, METODO);
    }

    private Metodo(Name alias, Table<MetodoRecord> aliased) {
        this(alias, aliased, null);
    }

    private Metodo(Name alias, Table<MetodoRecord> aliased, Field<?>[] parameters) {
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
        return Arrays.<Index>asList(Indexes.METODO_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<MetodoRecord, Long> getIdentity() {
        return Keys.IDENTITY_METODO;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<MetodoRecord> getPrimaryKey() {
        return Keys.KEY_METODO_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<MetodoRecord>> getKeys() {
        return Arrays.<UniqueKey<MetodoRecord>>asList(Keys.KEY_METODO_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Metodo as(String alias) {
        return new Metodo(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Metodo as(Name alias) {
        return new Metodo(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Metodo rename(String name) {
        return new Metodo(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Metodo rename(Name name) {
        return new Metodo(name, null);
    }
}