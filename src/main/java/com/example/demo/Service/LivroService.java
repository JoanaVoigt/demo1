package com.example.demo.Service;

import com.example.demo.Model.Dto.LivroPostDto;
import com.example.demo.Model.Dto.LivroPutDto;
import com.example.demo.Model.Entity.Livro;
import com.example.demo.Repository.LivroRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class LivroService {
    private final LivroRepository repository;

    public LivroService(LivroRepository repository) {
        this.repository = repository;
    }

    public List<Livro> listarTodos(){
        return repository.findAll();
    }

    public Livro adicionarLivro(LivroPostDto livroPostDto){
        Livro livro = livroPostDto.convert();
        if(livro.getAnoPublicacao() < 1500){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        return repository.save(livro);
    }

    public Livro buscarLivroPorIf(Long id){
        return repository.findById(id).get();
    }

    public Livro editarLivro(LivroPutDto livroPutDto){
        return repository.save(livroPutDto.convert());
    }

    public void deletar(Long id){
        repository.deleteById(id);
    }
}
