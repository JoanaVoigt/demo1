package com.example.demo.Model.Dto;

import com.example.demo.Model.Entity.Editora;
import com.example.demo.Model.Entity.Livro;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record LivroPostDto(
        @NotBlank
        String titulo,
        @NotBlank
        String autor,
        @NotNull
        int anoPublicacao
) {

        public Livro convert(){
                Livro livro = new Livro();

                livro.setTitulo(this.titulo);
                livro.setAutor(this.autor);
                livro.setAnoPublicacao(this.anoPublicacao);
                return livro;
        }
}
