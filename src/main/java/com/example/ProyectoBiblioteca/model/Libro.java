package com.example.ProyectoBiblioteca.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Libro {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private Long isbn;
    @Column
    private String titulo;
    @Column
    private Integer anio;
    @Column
    private Integer ejemplares;
    @Column
    private Integer ejemplaresPrestados;
    @Column
    private Integer ejemplaresRestantes;
    @Column
    private Boolean alta;
    @ManyToOne
    @JoinColumn(name = "autor")
    private Autor autor;
    @ManyToOne
    @JoinColumn(name = "editorial")
    private Editorial editorial;


}