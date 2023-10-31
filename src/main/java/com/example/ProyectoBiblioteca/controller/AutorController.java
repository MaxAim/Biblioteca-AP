package com.example.ProyectoBiblioteca.controller;

import com.example.ProyectoBiblioteca.model.Autor;
import com.example.ProyectoBiblioteca.service.AutorI;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/autores")
public class AutorController {
    private final AutorI autorService;

    @GetMapping("/findAll")
    public ResponseEntity<List<Autor>> findAllAutores(){
        List<Autor> lista = autorService.findAllAutors();
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<String> saveAutor(@RequestBody Autor autor){
        String mensaje = autorService.saveAutor(autor);
        return new ResponseEntity<>(mensaje, HttpStatus.CREATED);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateAutor(@RequestBody Autor autor, @PathVariable Long id){
        String mensaje = autorService.updateAutor(id, autor);
        return new ResponseEntity<>(mensaje, HttpStatus.OK);
    }

    @PutMapping("/alta/{id}")
    public ResponseEntity<String> altaEditorial(@PathVariable Long id){
        String mensaje = autorService.altaAutor(id);
        return new ResponseEntity<>(mensaje, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Autor> findAutor(@PathVariable Long id){
        Autor mensaje = autorService.findAutor(id);
        return new ResponseEntity<>(mensaje, HttpStatus.FOUND);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteAutor(@PathVariable Long id){
        String mensaje = autorService.deleteAutor(id);
        return new ResponseEntity<>(mensaje, HttpStatus.OK);
    }
}