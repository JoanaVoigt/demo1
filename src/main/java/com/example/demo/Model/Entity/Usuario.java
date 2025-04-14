package com.example.demo.Model.Entity;

import com.example.demo.Model.Dto.UsuarioGetDto;
import jakarta.persistence.*;

@Entity(name = "tb_usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String email;
    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL)
    private Emprestimo emprestimo;

    public Usuario(Long id, String nome, String email, Emprestimo emprestimo) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.emprestimo = emprestimo;
    }

    public Usuario() {

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Emprestimo getEmprestimo() {
        return emprestimo;
    }

    public void setEmprestimo(Emprestimo emprestimo) {
        this.emprestimo = emprestimo;
    }

    public UsuarioGetDto toGetDto(){
        return new UsuarioGetDto(nome, email);
    }
}
