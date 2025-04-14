package com.example.demo.Model.Entity;

import jakarta.persistence.*;

import java.util.List;

@Entity(name = "tb_editora")
public class Editora {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String cidade;
    @OneToMany(mappedBy = "editora")
    private List<Livro> livro;

    public Editora(Long id, String nome, String cidade, List<Livro> livro) {
        this.id = id;
        this.nome = nome;
        this.cidade = cidade;
        this.livro = livro;
    }

    public Editora() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public List<Livro> getLivro() {
        return livro;
    }

    public void setLivro(List<Livro> livro) {
        this.livro = livro;
    }
}
