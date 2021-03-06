package com.viridian.dummybank.utils;

import java.math.BigDecimal;

/**
 * Created by marcelo on 28-02-18
 */
public class TransferenciaUtils {
    public static final Long STATUS_ACTIVA = 1L;
    public static final Long STATUS_PARC_COMPR = 2L;
    public static final Long AUTORIZACION_PARA_REVERTIR = 1L; // usar este valor por defecto
    public static final Long METODO_CUENTAS_PROPIAS = 4L;
    public static final Long METODO_CUENTAS_TERCEROS = 5L;
    public static final Long METODO_CUENTAS_OTROS = 6L;
    public static final Long METODO_REVERSION = 7L;
    public static final Long NUMERO_ORDEN_DEF = 1L; // ?
    public static final Long OPERACION_DEPOSITO = 2L;
    public static final Long OPERADOR_DEF = 3L;
    public static final Long REGISTRO_FACTURACION = 1L;
    public static final Long BENEFICIARIO_DEF = 1L; // revision como obtener al beneficiario
    public static final BigDecimal SALDO_DEF = new BigDecimal(50);  // revisar calculo para el saldo
}
