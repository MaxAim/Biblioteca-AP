package com.example.ProyectoBiblioteca.repository;

import com.example.ProyectoBiblioteca.model.Editorial;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EditorialRepository extends JpaRepository<Editorial, Long> {

        Optional<Editorial> findById(Long id);
}

