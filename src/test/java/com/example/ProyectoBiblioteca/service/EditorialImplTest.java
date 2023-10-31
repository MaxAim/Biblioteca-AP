package com.example.ProyectoBiblioteca.service;

import com.example.ProyectoBiblioteca.model.Editorial;
import com.example.ProyectoBiblioteca.model.Editorial;
import com.example.ProyectoBiblioteca.model.Editorial;
import com.example.ProyectoBiblioteca.repository.EditorialRepository;
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
class EditorialImplTest {
    @InjectMocks
    private EditorialImpl editorialService;
    @Mock
    private EditorialRepository editorialRepository;
    private Editorial editorial = new Editorial(1L, "nombre", true);

    @Test
    void findAllEditoriales() {
        List<Editorial> mockList = new ArrayList<>();
        List<Editorial> listaTest = editorialService.findAllEditorials();
        assertNotNull(listaTest);
        assertTrue(listaTest.isEmpty());
    }

    @Test
    void saveEditorial() {
        when(editorialRepository.save(editorial)).thenReturn(editorial);
        String result = editorialService.saveEditorial(editorial);
        assertNotNull(result);
        verify(editorialRepository, times(1)).save(editorial);
    }

    @Test
    void findEditorial() {
        when(editorialRepository.findById(1L)).thenReturn(Optional.ofNullable(editorial));
        Editorial result = editorialService.findEditorial(1L);

        assertNotNull(result);
        assertEquals(result.getId(), editorial.getId());
    }

    @Test
    void updateEditorial() {
        when(editorialRepository.findById(anyLong())).thenReturn(Optional.ofNullable(editorial));
        String result = editorialService.updateEditorial(editorial.getId(), editorial);
        assertEquals(result, "Editorial: " + editorial.getNombre() + " actualizada exitosamente");
    }

    @Test
    void deleteEditorial() {
        doNothing().when(editorialRepository).deleteById(1L);
        String result = editorialService.deleteEditorial(1L);
        assertEquals("La editorial fue eliminada exitosamente", result);
    }

    @Test
    void altaEditorial() {
        when(editorialRepository.findById(anyLong())).thenReturn(Optional.ofNullable(editorial));
        editorialService.updateEditorial(anyLong(), editorial);
        String result = editorialService.altaEditorial(editorial.getId());
        assertEquals(result, "Editorial no esta de alta");
    }
}