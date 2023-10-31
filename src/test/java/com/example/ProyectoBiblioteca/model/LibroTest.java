package com.example.ProyectoBiblioteca.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class LibroTest {
    Autor autor = mock(Autor.class);
    Editorial editorial = mock(Editorial.class);
    private Libro libro = new Libro(1L, 123456789L, "titulo", 2000, 10, 7, 3, true, autor, editorial);

    @Test
    void getIdTest(){
        assertEquals(1L, libro.getId());
        assertNotNull(libro.getId());
    }
    @Test
    void getIsbnTest() {
        assertEquals(123456789L, libro.getIsbn());
    }
    @Test
    void getTituloTest() {
        assertEquals("titulo", libro.getTitulo());
    }

    @Test
    void getAnioTest() {
        assertEquals(2000, libro.getAnio());
    }
    @Test
    void getEjemplaresTest() {
        assertEquals(10, libro.getEjemplares());
    }
    @Test
    void getEjemplaresPrestadosTest() {
        assertEquals(7, libro.getEjemplaresPrestados());
    }
    @Test
    void getEjemplaresRestantesTest() {
        assertEquals(3, libro.getEjemplaresRestantes());
    }
    @Test
    void getAltaTest(){
        assertTrue(libro.getAlta());
    }
    @Test
    void getAutorTest() {
        assertEquals(autor, libro.getAutor());
    }
    @Test
    void getEditorialTest() {
        assertEquals(editorial, libro.getEditorial());
    }
    @Test
    void setIdTest(){
        libro.setId(2L);
        assertEquals(2L, libro.getId());
        assertNotNull(libro.getId());
    }
    @Test
    void setIsbnTest() {
        libro.setIsbn(987654321L);
        assertEquals(987654321L, libro.getIsbn());
    }
    @Test
    void setTituloTest() {
        libro.setTitulo("titulo2");
        assertEquals("titulo2", libro.getTitulo());
    }

    @Test
    void setAnioTest() {
        libro.setAnio(2015);
        assertEquals(2015, libro.getAnio());
    }
    @Test
    void setEjemplaresTest() {
        libro.setEjemplares(12);
        assertEquals(12, libro.getEjemplares());
    }
    @Test
    void setEjemplaresPrestadosTest() {
        libro.setEjemplaresPrestados(8);
        assertEquals(8, libro.getEjemplaresPrestados());
    }
    @Test
    void setEjemplaresRestantesTest() {
        libro.setEjemplaresRestantes(4);
        assertEquals(4, libro.getEjemplaresRestantes());
    }
    @Test
    void setAltaTest(){
        libro.setAlta(false);
        assertFalse(libro.getAlta());
    }
    @Test
    void setAutorTest() {
        Autor autor2 = mock(Autor.class);
        libro.setAutor(autor2);
        assertEquals(autor2, libro.getAutor());
    }
    @Test
    void setEditorialTest() {
        Editorial editorial2 = mock(Editorial.class);
        libro.setEditorial(editorial2);
        assertEquals(editorial2, libro.getEditorial());
    }
}