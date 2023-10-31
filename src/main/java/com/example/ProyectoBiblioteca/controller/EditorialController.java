package com.example.ProyectoBiblioteca.controller;

import com.example.ProyectoBiblioteca.model.Editorial;
import com.example.ProyectoBiblioteca.service.EditorialI;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/editoriales")
public class EditorialController {
    private final EditorialI editorialService;

    @GetMapping("/findAll")
    public ResponseEntity<List<Editorial>> findAllEditoriales(){
        List<Editorial> lista = editorialService.findAllEditorials();

        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<String> saveEditorial(@RequestBody Editorial editorial){
        String mensaje = editorialService.saveEditorial(editorial);
        return new ResponseEntity<>(mensaje, HttpStatus.CREATED);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateEditorial(@RequestBody Editorial editorial, @PathVariable Long id){
        String mensaje = editorialService.updateEditorial(id, editorial);
        return new ResponseEntity<>(mensaje, HttpStatus.OK);
    }

    @PutMapping("/alta/{id}")
    public ResponseEntity<String> altaEditorial(@PathVariable Long id){
        String mensaje = editorialService.altaEditorial(id);
        return new ResponseEntity<>(mensaje, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Editorial> findEditorial(@PathVariable Long id){
        Editorial mensaje = editorialService.findEditorial(id);
        return new ResponseEntity<>(mensaje, HttpStatus.FOUND);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEditorial(@PathVariable Long id){
        String mensaje = editorialService.deleteEditorial(id);
        return new ResponseEntity<>(mensaje, HttpStatus.OK);
    }
}
