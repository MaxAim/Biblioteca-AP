package com.example.ProyectoBiblioteca.repository;

import com.example.ProyectoBiblioteca.model.Autor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class AutorRepositoryTest {

    @Autowired
    private AutorRepository autorRepository;
    @Test
    void findById() {
        Autor autorEncontrado = autorRepository.findById(1L).orElseThrow();
        assertEquals(1L, autorEncontrado.getId());
    }

}