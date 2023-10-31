package com.example.ProyectoBiblioteca.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AutorTest {

    Autor autor = new Autor(1L, "nombre", true);
    @Test
    void getIdTest(){
        assertEquals(1L, autor.getId());
        assertNotNull(autor.getId());
    }

    @Test
    void getNombreTest(){
        assertEquals("nombre", autor.getNombre());
    }

    @Test
    void getAltaTest(){
        assertTrue(autor.getAlta());
    }

    @Test
    void setIdTest(){
        assertEquals(1L, autor.getId());
    }

    @Test
    void setNombreTest(){
        autor.setNombre("nombre2");
        assertEquals("nombre2", autor.getNombre());
    }

    @Test
    void setAltaTest(){
        autor.setAlta(false);
        assertFalse(autor.getAlta());
    }
}