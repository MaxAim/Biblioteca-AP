package com.example.ProyectoBiblioteca.repository;

import com.example.ProyectoBiblioteca.model.Autor;
import com.example.ProyectoBiblioteca.model.Editorial;
import com.example.ProyectoBiblioteca.model.Libro;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class LibroRepositoryTest {
    @Autowired
    private LibroRepository libroRepository;

    @Test
    void findByIdTest(){
        Libro libroEncontrado = libroRepository.findById(1L).orElseThrow();
        assertEquals(1L, libroEncontrado.getId());
    }
}
