package com.example.demo.model.enums;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RolTest {

    @Test
    public void testEnumValues() {
        // Verificar que los valores enumerados sean los esperados
        assertEquals("PROPIETARIO", Rol.PROPIETARIO.name());
        assertEquals("ADMINISTRADOR", Rol.ADMINISTRADOR.name());
        assertEquals("EMPLEADO", Rol.EMPLEADO.name());
    }

    @Test
    public void testEnumValuesCount() {
        // Verificar que la enumeración tiene la cantidad correcta de valores
        assertEquals(3, Rol.values().length);
    }

}