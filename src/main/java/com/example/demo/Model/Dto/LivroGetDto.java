package com.example.demo.Model.Dto;

import com.example.demo.Model.Entity.Editora;
import com.example.demo.Model.Entity.Emprestimo;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record LivroGetDto (
        String titulo,
        String autor
){
}
