package com.example.ProyectoBiblioteca.service;

import com.example.ProyectoBiblioteca.model.Editorial;
import com.example.ProyectoBiblioteca.model.Libro;
import com.example.ProyectoBiblioteca.repository.EditorialRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EditorialImpl implements EditorialI{
    private final EditorialRepository editorialRepository;

    @Override
    public List<Editorial> findAllEditorials() {
        return new ArrayList<>(editorialRepository.findAll());
    }

    @Override
    public String saveEditorial(Editorial editorial) {
        editorialRepository.save(editorial);
        return "Editorial guardado exitosamente";
    }

    @Override
    public Editorial findEditorial(Long id) {
        return editorialRepository.findById(id).orElseThrow();
    }


    @Override
    public String updateEditorial(Long id, Editorial editorial) {
        Editorial update = editorialRepository.findById(id).orElseThrow();
        update.setId(editorial.getId());
        update.setNombre(editorial.getNombre());
        update.setAlta(editorial.getAlta());
        editorialRepository.save(editorial);

        return "Editorial: " + editorial.getNombre() + " actualizada exitosamente";
    }

    @Override
    public String deleteEditorial(Long id) {
        editorialRepository.deleteById(id);

        return "La editorial fue eliminada exitosamente";
    }

    @Override
    public String altaEditorial(Long id) {
        Editorial editorial = editorialRepository.findById(id).orElseThrow();
        editorial.setAlta(!editorial.getAlta());
        updateEditorial(id, editorial);
        return editorial.getAlta() ? "Editorial esta de alta" : "Editorial no esta de alta";
    }

}
