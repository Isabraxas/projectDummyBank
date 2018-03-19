/*
 * This file is generated by jOOQ.
*/
package com.viridian.dummybank.gensrc.jooq.tables.records;


import com.viridian.dummybank.gensrc.jooq.tables.PersonaNatural;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record2;
import org.jooq.Row2;
import org.jooq.impl.UpdatableRecordImpl;


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
public class PersonaNaturalRecord extends UpdatableRecordImpl<PersonaNaturalRecord> implements Record2<Long, Long> {

    private static final long serialVersionUID = 1595346462;

    /**
     * Setter for <code>viridianbank.Persona_Natural.id_cliente</code>.
     */
    public void setIdCliente(Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>viridianbank.Persona_Natural.id_cliente</code>.
     */
    public Long getIdCliente() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>viridianbank.Persona_Natural.persona_id</code>.
     */
    public void setPersonaId(Long value) {
        set(1, value);
    }

    /**
     * Getter for <code>viridianbank.Persona_Natural.persona_id</code>.
     */
    public Long getPersonaId() {
        return (Long) get(1);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record1<Long> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record2 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row2<Long, Long> fieldsRow() {
        return (Row2) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row2<Long, Long> valuesRow() {
        return (Row2) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field1() {
        return PersonaNatural.PERSONA_NATURAL.ID_CLIENTE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field2() {
        return PersonaNatural.PERSONA_NATURAL.PERSONA_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component1() {
        return getIdCliente();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component2() {
        return getPersonaId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value1() {
        return getIdCliente();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value2() {
        return getPersonaId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PersonaNaturalRecord value1(Long value) {
        setIdCliente(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PersonaNaturalRecord value2(Long value) {
        setPersonaId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PersonaNaturalRecord values(Long value1, Long value2) {
        value1(value1);
        value2(value2);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached PersonaNaturalRecord
     */
    public PersonaNaturalRecord() {
        super(PersonaNatural.PERSONA_NATURAL);
    }

    /**
     * Create a detached, initialised PersonaNaturalRecord
     */
    public PersonaNaturalRecord(Long idCliente, Long personaId) {
        super(PersonaNatural.PERSONA_NATURAL);

        set(0, idCliente);
        set(1, personaId);
    }
}
