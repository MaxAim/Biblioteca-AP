package com.example.ProyectoBiblioteca.controller;

import com.example.ProyectoBiblioteca.model.Editorial;
import com.example.ProyectoBiblioteca.service.EditorialImpl;
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

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@WebMvcTest(EditorialController.class)
class EditorialControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private EditorialImpl editorialService;

    Editorial editorial = mock(Editorial.class);
    Editorial editorial2 = mock(Editorial.class);
    List<Editorial> editorialList = new ArrayList<>();

    @Test
    void findAllEditorialsTest() throws Exception {
        editorialList.add(editorial);
        editorialList.add(editorial2);
        when(editorialService.findAllEditorials()).thenReturn(editorialList);
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/editoriales/findAll")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
    }

    @Test
    void saveEditorialTest() throws Exception {
        when(editorialService.saveEditorial(editorial)).thenReturn("Editorial guardada exitosamente");
        mockMvc.perform(MockMvcRequestBuilders
                        .post("/editoriales/save")
                        .content("{\"id\": 1,\"nombre\": \"placeholder_editorial_1\",\"alta\": true}}")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }

    @Test
    void updateEditorialTest() throws Exception {
        when(editorialService.updateEditorial(editorial.getId(), editorial)).thenReturn("Editorial: titulo actualizada exitosamente");
        mockMvc.perform(MockMvcRequestBuilders
                        .put("/editoriales/update/1")
                        .content("{\"id\": 1,\"nombre\": \"placeholder_editorial_1\",\"alta\": true}}}")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
    }

    @Test
    void altaEditorial() throws Exception{
        when(editorialService.altaEditorial(editorial.getId())).thenReturn("Editorial esta de alta");
        mockMvc.perform(MockMvcRequestBuilders
            .put("/editoriales/alta/1")
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
    }
    @Test
    void findEditorialTest() throws Exception{
        editorial.setAlta(true);
        editorial.setId(1L);
        when(editorialService.findEditorial(editorial.getId())).thenReturn((editorial));
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/editoriales/find/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isFound());
    }

    @Test
    void deleteEditorialTest() throws Exception {
        when(editorialService.deleteEditorial(editorial.getId())).thenReturn("El editorial fue eliminada exitosamente");
        mockMvc.perform(MockMvcRequestBuilders
            .delete("/editoriales/delete/1")
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
    }
}