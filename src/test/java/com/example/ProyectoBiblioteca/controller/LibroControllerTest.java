package com.example.ProyectoBiblioteca.controller;

import com.example.ProyectoBiblioteca.service.LibroImpl;
import com.example.ProyectoBiblioteca.model.Libro;
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


@WebMvcTest(LibroController.class)
class LibroControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private LibroImpl libroService;

    Libro libro = mock(Libro.class);
    Libro libro2 = mock(Libro.class);
    List<Libro> libroList = new ArrayList<>();

    @Test
    void findAllLibrosTest() throws Exception {
        libroList.add(libro);
        libroList.add(libro2);
        when(libroService.findAllLibros()).thenReturn(libroList);
        mockMvc.perform(MockMvcRequestBuilders
            .get("/libros/findAll")
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().is2xxSuccessful()
        );
    }

    @Test
    void saveLibroTest() throws Exception {
        when(libroService.saveLibro(libro)).thenReturn("Libro guardado exitosamente");
        mockMvc.perform(MockMvcRequestBuilders
            .post("/libros/save")
            .content("{\"id\": 1,\"isbn\": 1234567890,\"titulo\": \"placeholder_titulo_1\",\"anio\": 2000,\"ejemplares\": 10,\"ejemplaresPrestados\": 3,\"ejemplaresRestantes\": 7,\"alta\": true,\"autor\": {\"id\": 1,\"nombre\": \"placeholder_autor_1\",\"alta\": true},\"editorial\": {\"id\": 1,\"nombre\": \"placeholder_editorial_1\", \"alta\": true}}")
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isCreated());
    }

    @Test
    void updateLibroTest() throws Exception {
        when(libroService.updateLibro(libro.getId(), libro)).thenReturn("Libro: titulo actualizado exitosamente");
        mockMvc.perform(MockMvcRequestBuilders
            .put("/libros/update/1")
            .content("{\"id\": 1,\"isbn\": 1234567890,\"titulo\": \"placeholder_titulo_1\",\"anio\": 2000,\"ejemplares\": 10,\"ejemplaresPrestados\": 3,\"ejemplaresRestantes\": 7,\"alta\": true,\"autor\": {\"id\": 1,\"nombre\": \"placeholder_autor_1\",\"alta\": true},\"editorial\": {\"id\": 1,\"nombre\": \"placeholder_editorial_1\", \"alta\": true}}")
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
    }

    @Test
    void altaLibro() throws Exception{
        when(libroService.altaLibro(libro.getId())).thenReturn("Libro esta de alta");
        mockMvc.perform(MockMvcRequestBuilders
            .put("/libros/alta/1")
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
    }
    @Test
    void findLibroTest() throws Exception{
        libro.setAlta(true);
        libro.setId(1L);
        when(libroService.findLibro(libro.getId())).thenReturn((libro));
        mockMvc.perform(MockMvcRequestBuilders
            .get("/libros/find/1")
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isFound());
    }

    @Test
    void deleteLibroTest() throws Exception {
        when(libroService.deleteLibro(libro.getId())).thenReturn("El libro fue eliminado exitosamente");
        mockMvc.perform(MockMvcRequestBuilders
            .delete("/libros/delete/1")
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
    }
}

