package com.example.ProyectoBiblioteca.service;

import com.example.ProyectoBiblioteca.model.Autor;
import com.example.ProyectoBiblioteca.model.Editorial;
import com.example.ProyectoBiblioteca.model.Libro;
import com.example.ProyectoBiblioteca.repository.LibroRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@SpringBootTest
class LibroImplTest {
    @InjectMocks
    private LibroImpl libroService;
    @Mock
    private LibroRepository libroRepository;
    private Autor autor = mock(Autor.class);
    private Editorial editorial = mock(Editorial.class);
    private Libro libro = new Libro(1L, 123456789L, "titulo", 2000, 10, 7, 3, true, autor, editorial);

    @Test
    void findAllLibros() {
        List<Libro> mockList = new ArrayList<>();
        List<Libro> listaTest = libroService.findAllLibros();
        assertNotNull(listaTest);
        assertTrue(listaTest.isEmpty());
    }

    @Test
    void saveLibro() {
        when(libroRepository.save(libro)).thenReturn(libro);
        String result = libroService.saveLibro(libro);
        assertNotNull(result);
        verify(libroRepository, times(1)).save(libro);
    }

    @Test
    void findLibro() {
        when(libroRepository.findById(1L)).thenReturn(Optional.ofNullable(libro));
        Libro result = libroService.findLibro(1L);

        assertNotNull(result);
        assertEquals(result.getTitulo(), libro.getTitulo());
    }

    @Test
    void updateLibro() {
        when(libroRepository.findById(anyLong())).thenReturn(Optional.ofNullable(libro));
        String result = libroService.updateLibro(libro.getId(), libro);
        assertEquals(result, "Libro: " + libro.getTitulo() + " actualizado exitosamente");
    }

    @Test
    void deleteLibro() {
        doNothing().when(libroRepository).deleteById(1L);
        String result = libroService.deleteLibro(1L);
        assertEquals("El libro fue eliminado exitosamente", result);
    }

    @Test
    void altaLibro() {
        when(libroRepository.findById(anyLong())).thenReturn(Optional.ofNullable(libro));
        libroService.updateLibro(anyLong(), libro);
        String result = libroService.altaLibro(libro.getId());
        assertEquals(result, "Libro no esta de alta");
    }
}