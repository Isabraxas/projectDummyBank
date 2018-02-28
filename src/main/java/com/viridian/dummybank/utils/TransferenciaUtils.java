package com.viridian.dummybank.utils;

import java.math.BigDecimal;

/**
 * Created by marcelo on 28-02-18
 */
public class TransferenciaUtils {
    public static final Long STATUS_COMPLETA = 6L; // todo añadir esto a la tabla EStatus
    public static final Long AUTORIZACION_DEF = 1L; // usar este valor por defecto
    public static final Long METODO_CUENTAS_PROPIAS = 4L; // ?
    public static final Long NUMERO_ORDEN_DEF = 1L; // ?
    public static final Long OPERACION_DEPOSITO = 2L;
    public static final Long OPERADOR_DEF = 0L;
    public static final Long REGISTRO_FACTURACION = 1L;
    public static final Long BENEFICIARIO_DEF = 1L;
    public static final BigDecimal SALDO_DEF = new BigDecimal(50);  // revisar calculo para el saldo
}
