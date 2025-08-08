package com.tapiceria.union;

import com.tapiceria.union.model.Trabajo;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TrabajoTest {
    @Test
    void creaTrabajoPendiente() {
        Trabajo t = new Trabajo(1, "Cliente X", "Sillón", "2025-08-30", "Pendiente");
        assertEquals("Pendiente", t.getEstado());
        assertEquals("Cliente X", t.getCliente());
        assertEquals("Sillón", t.getTipoMueble());
        assertEquals("2025-08-30", t.getFechaEntrega());
    }
}
