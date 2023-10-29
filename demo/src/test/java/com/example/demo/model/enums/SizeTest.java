package com.example.demo.model.enums;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SizeTest {

    @Test
    public void testEnumValues() {
        // Verificar que los valores enumerados sean los esperados
        assertEquals("XS", Size.XS.name());
        assertEquals("S", Size.S.name());
        assertEquals("M", Size.M.name());
        assertEquals("L", Size.L.name());
        assertEquals("XL", Size.XL.name());
        assertEquals("XXL", Size.XXL.name());
    }

    @Test
    public void testEnumValuesCount() {
        // Verificar que la enumeración tiene la cantidad correcta de valores
        assertEquals(6, Size.values().length);
    }

    // Puedes agregar más pruebas según tus necesidades

}



