package br.edu.ifba.demo.frontend.dto;

import java.sql.Date;
import java.time.LocalDateTime;

import lombok.Data;

@Data
public class LivroDTO {
    private Long id_livro;
    private String titulo;
    private String autor;
    private String editora;
    private Date ano_publicacao;
    private String genero;
    private String isbn;
    private String num_paginas;
    private String sinopse;
    private String idioma;
    private LocalDateTime data_cadastro;
    private Double preco;
}

