package com.example.demo.Service;

import com.example.demo.Model.Dto.EmprestimoPostDto;
import com.example.demo.Model.Dto.EmprestimoPutDto;
import com.example.demo.Model.Entity.Emprestimo;
import com.example.demo.Model.Entity.Livro;
import com.example.demo.Model.Entity.Usuario;
import com.example.demo.Repository.EmprestimoRepository;
import com.example.demo.Repository.LivroRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import java.util.List;

@Service
public class EmprestimoService {
    private final EmprestimoRepository repository;
    private final LivroRepository livroRepository;

    public EmprestimoService(EmprestimoRepository repository, LivroRepository livroRepository) {
        this.repository = repository;
        this.livroRepository = livroRepository;
    }

    public Emprestimo adicionarEmprestimo(EmprestimoPostDto emprestimoPostDto) {
        // Buscar os livros diretamente pelo ID
        List<Livro> livros = livroRepository.findAllById(emprestimoPostDto.livrosId());

        // Verifica se a lista de livros está vazia, se sim, lança um erro
        if (livros.size() != emprestimoPostDto.livrosId().size()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Alguns livros não foram encontrados");
        }

        // Criar e configurar o emprestimo
        Emprestimo emprestimo = emprestimoPostDto.convert();
        Usuario usuario = new Usuario();
        usuario.setId(emprestimoPostDto.usuarioId());
        emprestimo.setUsuario(usuario);
        emprestimo.setLivros(livros);

        // Salvar o emprestimo
        return repository.save(emprestimo);
    }

    public List<Emprestimo> buscarTodos() {
        return repository.findAll();
    }

    public Emprestimo buscarPorId(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public Emprestimo editar(EmprestimoPutDto emprestimoPutDto) {
        return repository.save(emprestimoPutDto.convert());
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
