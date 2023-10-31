package com.example.ProyectoBiblioteca.service;

import com.example.ProyectoBiblioteca.model.Libro;

import java.util.List;

public interface LibroI {

    List<Libro> findAllLibros();
    String saveLibro(Libro libro);
    Libro findLibro(Long id);
    String updateLibro(Long id, Libro libro);
    String deleteLibro(Long id);
    String altaLibro(Long id);

}
