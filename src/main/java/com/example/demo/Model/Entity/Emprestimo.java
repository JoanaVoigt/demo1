package com.example.demo.Model.Entity;

import com.example.demo.Model.Dto.EmprestimoGetDto;
import jakarta.persistence.*;

import java.util.List;

@Entity(name = "tb_emprestimo")
public class Emprestimo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String dataEmprestimo;
    @Column(nullable = false)
    private String dataDevolucao;
    @OneToMany(mappedBy = "emprestimo")
    private List<Livro> livros;
    @OneToOne
    private Usuario usuario;

    public Emprestimo(Usuario usuario, List<Livro> livros, String dataDevolucao, String dataEmprestimo, Long id) {
        this.usuario = usuario;
        this.livros = livros;
        this.dataDevolucao = dataDevolucao;
        this.dataEmprestimo = dataEmprestimo;
        this.id = id;
    }

    public Emprestimo() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(String dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public String getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(String dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public void setLivros(List<Livro> livros) {
        this.livros = livros;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public EmprestimoGetDto toGetDto() {
        // Retorna um DTO com os IDs dos livros
        List<Long> livrosId = livros.stream().map(Livro::getId).toList();
        return new EmprestimoGetDto(dataEmprestimo, dataDevolucao, usuario.getId(), livrosId);
    }
}
