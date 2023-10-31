package com.example.ProyectoBiblioteca.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EditorialTest {
    Editorial editorial = new Editorial(1L, "nombre", true);
    @Test
    void getIdTest() {
        assertEquals(1L, editorial.getId());
        assertNotNull(editorial.getId());
    }

    @Test
    void getNombreTest() {
        assertEquals("nombre", editorial.getNombre());
    }

    @Test
    void getAltaTest() {
        assertTrue(editorial.getAlta());
    }

    @Test
    void setIdTest() {
        assertEquals(1L, editorial.getId());
    }

    @Test
    void setNombreTest() {
        editorial.setNombre("nombre2");
        assertEquals("nombre2", editorial.getNombre());
    }

    @Test
    void setAltaTest() {
        editorial.setAlta(false);
        assertFalse(editorial.getAlta());
    }
}