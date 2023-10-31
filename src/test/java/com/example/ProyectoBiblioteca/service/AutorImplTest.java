package com.example.ProyectoBiblioteca.service;

import com.example.ProyectoBiblioteca.model.Autor;
import com.example.ProyectoBiblioteca.repository.AutorRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class AutorImplTest {
    @InjectMocks
    private AutorImpl autorService;
    @Mock
    private AutorRepository autorRepository;
    private Autor autor = new Autor(1L, "nombre", true);

    @Test
    void findAllAutores() {
        List<Autor> mockList = new ArrayList<>();
        List<Autor> listaTest = autorService.findAllAutors();
        assertNotNull(listaTest);
        assertTrue(listaTest.isEmpty());
    }

    @Test
    void saveAutor() {
        when(autorRepository.save(autor)).thenReturn(autor);
        String result = autorService.saveAutor(autor);
        assertNotNull(result);
        verify(autorRepository, times(1)).save(autor);
    }

    @Test
    void findAutor() {
        when(autorRepository.findById(1L)).thenReturn(Optional.ofNullable(autor));
        Autor result = autorService.findAutor(1L);

        assertNotNull(result);
        assertEquals(result.getId(), autor.getId());
    }

    @Test
    void updateAutor() {
        when(autorRepository.findById(anyLong())).thenReturn(Optional.ofNullable(autor));
        String result = autorService.updateAutor(autor.getId(), autor);
        assertEquals(result, "Autor: " + autor.getNombre() + " actualizado exitosamente");
    }

    @Test
    void deleteAutor() {
        doNothing().when(autorRepository).deleteById(1L);
        String result = autorService.deleteAutor(1L);
        assertEquals("El autor fue eliminado exitosamente", result);
    }

    @Test
    void altaAutor() {
        when(autorRepository.findById(anyLong())).thenReturn(Optional.ofNullable(autor));
        autorService.updateAutor(anyLong(), autor);
        String result = autorService.altaAutor(autor.getId());
        assertEquals(result, "Autor no esta de alta");
    }
}