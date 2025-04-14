package com.example.demo.Model.Dto;

import com.example.demo.Model.Entity.Usuario;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UsuarioPostDto(
        @NotBlank
        String nome,
        @NotBlank
        @Email
        String email
) {

    public Usuario convert(){
        Usuario usuario = new Usuario();

        usuario.setNome(this.nome);
        usuario.setEmail(this.email);
        return usuario;
    }
}
