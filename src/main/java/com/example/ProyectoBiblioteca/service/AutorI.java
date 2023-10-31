package com.example.ProyectoBiblioteca.service;

import com.example.ProyectoBiblioteca.model.Autor;

import java.util.List;

public interface AutorI {
    List<Autor> findAllAutors();
    String saveAutor(Autor autor);
    Autor findAutor(Long id);
    String updateAutor(Long id, Autor autor);
    String deleteAutor(Long id);
    String altaAutor(Long id);
}
