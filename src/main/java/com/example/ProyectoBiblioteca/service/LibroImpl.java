package com.example.ProyectoBiblioteca.service;
import com.example.ProyectoBiblioteca.model.Libro;
import com.example.ProyectoBiblioteca.repository.LibroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LibroImpl implements LibroI{
    private final LibroRepository libroRepository;

    @Override
    public List<Libro> findAllLibros() {
        return libroRepository.findAll().stream().filter(Libro::getAlta).toList();
    }

    @Override
    public String saveLibro(Libro libro) {
        libroRepository.save(libro);
        return "Libro guardado exitosamente";
    }

    @Override
    public Libro findLibro(Long id) {
        return libroRepository.findById(id).orElseThrow();
    }

    @Override
    public String updateLibro(Long id, Libro libro) {
        Libro update = libroRepository.findById(id).orElseThrow();
        update.setIsbn(libro.getIsbn());
        update.setTitulo(libro.getTitulo());
        update.setAnio(libro.getAnio());
        update.setEjemplares(libro.getEjemplares());
        update.setEjemplaresPrestados(libro.getEjemplaresPrestados());
        update.setEjemplaresRestantes(libro.getEjemplaresRestantes());
        update.setAlta(libro.getAlta());
        update.setAutor(libro.getAutor());
        update.setEditorial(libro.getEditorial());

        libroRepository.save(update);

        return "Libro: " + libro.getTitulo() + " actualizado exitosamente";
    }

    @Override
    public String deleteLibro(Long id) {
        libroRepository.deleteById(id);

        return "El libro fue eliminado exitosamente";
    }

    @Override
    public String altaLibro(Long id) {
        Libro libro = libroRepository.findById(id).orElseThrow();
        libro.setAlta(!libro.getAlta());
        updateLibro(id, libro);
        return libro.getAlta() ? "Libro esta de alta" : "Libro no esta de alta";
    }

}
