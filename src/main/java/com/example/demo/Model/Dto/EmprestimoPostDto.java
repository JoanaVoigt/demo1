package com.example.demo.Model.Dto;

import com.example.demo.Model.Entity.Emprestimo;
import com.example.demo.Model.Entity.Livro;
import com.example.demo.Model.Entity.Usuario;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;

public record EmprestimoPostDto(
        @NotBlank String dataEmprestimo,
        @NotBlank String dataDevolucao,
        @NotNull Long usuarioId,
        @NotNull List<Long> livrosId
) {
    public Emprestimo convert() {
        Emprestimo emprestimo = new Emprestimo();
        emprestimo.setDataEmprestimo(this.dataEmprestimo);
        emprestimo.setDataDevolucao(this.dataDevolucao);

        Usuario usuario = new Usuario();
        usuario.setId(this.usuarioId);
        emprestimo.setUsuario(usuario);

        List<Livro> livros = new ArrayList<>();
        for (Long idLivro : this.livrosId) {
            Livro livro = new Livro();
            livro.setId(idLivro);
            livros.add(livro);
        }
        emprestimo.setLivros(livros);

        return emprestimo;
    }
}
