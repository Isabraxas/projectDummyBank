/*
 * This file is generated by jOOQ.
*/
package com.viridian.dummybank.gensrc.jooq.tables.records;


import com.viridian.dummybank.gensrc.jooq.tables.ClienteBeneficiario;

import javax.annotation.Generated;

import org.jooq.Field;
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
public class ClienteBeneficiarioRecord extends UpdatableRecordImpl<ClienteBeneficiarioRecord> implements Record2<Long, Long> {

    private static final long serialVersionUID = 1651873223;

    /**
     * Setter for <code>viridianbank.Cliente_Beneficiario.cliente_id</code>.
     */
    public void setClienteId(Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>viridianbank.Cliente_Beneficiario.cliente_id</code>.
     */
    public Long getClienteId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>viridianbank.Cliente_Beneficiario.beneficiario_id</code>.
     */
    public void setBeneficiarioId(Long value) {
        set(1, value);
    }

    /**
     * Getter for <code>viridianbank.Cliente_Beneficiario.beneficiario_id</code>.
     */
    public Long getBeneficiarioId() {
        return (Long) get(1);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record2<Long, Long> key() {
        return (Record2) super.key();
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
        return ClienteBeneficiario.CLIENTE_BENEFICIARIO.CLIENTE_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field2() {
        return ClienteBeneficiario.CLIENTE_BENEFICIARIO.BENEFICIARIO_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component1() {
        return getClienteId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component2() {
        return getBeneficiarioId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value1() {
        return getClienteId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value2() {
        return getBeneficiarioId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ClienteBeneficiarioRecord value1(Long value) {
        setClienteId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ClienteBeneficiarioRecord value2(Long value) {
        setBeneficiarioId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ClienteBeneficiarioRecord values(Long value1, Long value2) {
        value1(value1);
        value2(value2);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached ClienteBeneficiarioRecord
     */
    public ClienteBeneficiarioRecord() {
        super(ClienteBeneficiario.CLIENTE_BENEFICIARIO);
    }

    /**
     * Create a detached, initialised ClienteBeneficiarioRecord
     */
    public ClienteBeneficiarioRecord(Long clienteId, Long beneficiarioId) {
        super(ClienteBeneficiario.CLIENTE_BENEFICIARIO);

        set(0, clienteId);
        set(1, beneficiarioId);
    }
}