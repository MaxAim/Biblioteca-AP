package com.example.ProyectoBiblioteca.controller;

import com.example.ProyectoBiblioteca.model.Libro;
import com.example.ProyectoBiblioteca.service.LibroI;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/libros")
public class LibroController {
    private final LibroI libroService;

    @GetMapping("/findAll")
    public ResponseEntity<List<Libro>> findAllLibros(){
        List<Libro> lista = libroService.findAllLibros();

        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<String> saveLibro(@RequestBody Libro libro){
        String mensaje = libroService.saveLibro(libro);
        return new ResponseEntity<>(mensaje, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateLibro(@RequestBody Libro libro, @PathVariable Long id){
        String mensaje = libroService.updateLibro(id, libro);
        return new ResponseEntity<>(mensaje, HttpStatus.OK);
    }

    @PutMapping("/alta/{id}")
    public ResponseEntity<String> altaEditorial(@PathVariable Long id){
        String mensaje = libroService.altaLibro(id);
        return new ResponseEntity<>(mensaje, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Libro> findLibro(@PathVariable Long id){
        Libro mensaje = libroService.findLibro(id);
        return new ResponseEntity<>(mensaje, HttpStatus.FOUND);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteLibro(@PathVariable Long id){
        String mensaje = libroService.deleteLibro(id);
        return new ResponseEntity<>(mensaje, HttpStatus.OK);
    }

}
