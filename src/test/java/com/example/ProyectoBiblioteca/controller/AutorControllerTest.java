package com.example.ProyectoBiblioteca.controller;

import com.example.ProyectoBiblioteca.model.Autor;
import com.example.ProyectoBiblioteca.service.AutorImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@WebMvcTest(AutorController.class)
class AutorControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private AutorImpl autorService;

    Autor autor = mock(Autor.class);
    Autor autor2 = mock(Autor.class);
    List<Autor> autorList = new ArrayList<>();

    @Test
    void findAllAutorsTest() throws Exception {
        autorList.add(autor);
        autorList.add(autor2);
        when(autorService.findAllAutors()).thenReturn(autorList);
        mockMvc.perform(MockMvcRequestBuilders
            .get("/autores/findAll")
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
    }

    @Test
    void saveAutorTest() throws Exception {
        when(autorService.saveAutor(autor)).thenReturn("Autor guardado exitosamente");
        mockMvc.perform(MockMvcRequestBuilders
            .post("/autores/save")
            .content("{\"id\": 1,\"nombre\": \"placeholder_autor_1\",\"alta\": true}}")
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isCreated());
    }

    @Test
    void updateAutorTest() throws Exception {
        when(autorService.updateAutor(autor.getId(), autor)).thenReturn("Autor: titulo actualizado exitosamente");
        mockMvc.perform(MockMvcRequestBuilders
            .put("/autores/update/1")
            .content("{\"id\": 1,\"nombre\": \"placeholder_autor_1\",\"alta\": true}}}")
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
    }

    @Test
    void altaAutor() throws Exception{
        when(autorService.altaAutor(autor.getId())).thenReturn("Autor esta de alta");
        mockMvc.perform(MockMvcRequestBuilders
            .put("/autores/alta/1")
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
    }
    @Test
    void findAutorTest() throws Exception{
        autor.setAlta(true);
        autor.setId(1L);
        when(autorService.findAutor(autor.getId())).thenReturn((autor));
        mockMvc.perform(MockMvcRequestBuilders
            .get("/autores/find/1")
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isFound());
    }

    @Test
    void deleteAutorTest() throws Exception {
        when(autorService.deleteAutor(autor.getId())).thenReturn("El autor fue eliminado exitosamente");
        mockMvc.perform(MockMvcRequestBuilders
            .delete("/autores/delete/1")
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
    }
}