package com.example.ProyectoBiblioteca.service;

import com.example.ProyectoBiblioteca.model.Editorial;

import java.util.List;

public interface EditorialI {
    List<Editorial> findAllEditorials();
    String saveEditorial(Editorial editorial);
    Editorial findEditorial(Long id);
    String updateEditorial(Long id, Editorial editorial);
    String deleteEditorial(Long id);
    String altaEditorial(Long id);
}
