package com.example.ProyectoBiblioteca.repository;

import com.example.ProyectoBiblioteca.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Long> {

    Optional<Libro> findById(Long id);

    
}
