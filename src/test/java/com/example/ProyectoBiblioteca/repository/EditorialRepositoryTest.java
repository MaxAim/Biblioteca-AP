package com.example.ProyectoBiblioteca.repository;

import com.example.ProyectoBiblioteca.model.Autor;
import com.example.ProyectoBiblioteca.model.Editorial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EditorialRepositoryTest {
    @Autowired
    private EditorialRepository editorialRepository;
    @Test
    void findById() {
        Editorial editorialEncontrada = editorialRepository.findById(1L).orElseThrow();
        assertEquals(1L, editorialEncontrada.getId());
    }

}