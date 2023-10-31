package com.example.ProyectoBiblioteca.service;

import com.example.ProyectoBiblioteca.model.Autor;
import com.example.ProyectoBiblioteca.repository.AutorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AutorImpl implements AutorI {
    private final AutorRepository autorRepository;

    @Override
    public List<Autor> findAllAutors() {
        return new ArrayList<>(autorRepository.findAll());
    }

    @Override
    public String saveAutor(Autor autor) {
        autorRepository.save(autor);
        return "Autor guardado exitosamente";
    }

    @Override
    public Autor findAutor(Long id) {
        return autorRepository.findById(id).orElseThrow();
    }

    @Override
    public String updateAutor(Long id, Autor autor) {
        Autor update = autorRepository.findById(id).orElseThrow();
        update.setId(autor.getId());
        update.setNombre(autor.getNombre());
        update.setAlta(autor.getAlta());
        autorRepository.save(autor);

        return "Autor: " + autor.getNombre() + " actualizado exitosamente";
    }

    @Override
    public String deleteAutor(Long id) {
        autorRepository.deleteById(id);

        return "El autor fue eliminado exitosamente";
    }
    @Override
    public String altaAutor(Long id) {
        Autor autor = autorRepository.findById(id).orElseThrow();
        autor.setAlta(!autor.getAlta());
        updateAutor(id, autor);
        return autor.getAlta() ? "Autor esta de alta" : "Autor no esta de alta";
    }
}