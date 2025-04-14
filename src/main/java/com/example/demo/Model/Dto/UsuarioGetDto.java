package com.example.demo.Model.Dto;

import com.example.demo.Model.Entity.Emprestimo;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UsuarioGetDto(
        String nome,
        String email
) {
}
