package com.example.demo.model.enums;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PaymentMethodTest {

    @Test
    public void testEnumValues() {
        // Verificar que los valores enumerados sean los esperados
        assertEquals("DEBITO", PaymentMethod.DEBITO.name());
        assertEquals("CREDITO", PaymentMethod.CREDITO.name());
        assertEquals("EFECTIVO", PaymentMethod.EFECTIVO.name());
        assertEquals("TRANSFERENCIA", PaymentMethod.TRANSFERENCIA.name());
        assertEquals("DIVIDIDO", PaymentMethod.DIVIDIDO.name());
    }

    @Test
    public void testEnumValuesCount() {
        // Verificar que la enumeración tiene la cantidad correcta de valores
        assertEquals(5, PaymentMethod.values().length);
    }

}