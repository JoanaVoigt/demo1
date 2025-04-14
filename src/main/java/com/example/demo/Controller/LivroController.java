package com.example.demo.Controller;

import com.example.demo.Model.Dto.LivroGetDto;
import com.example.demo.Model.Dto.LivroPostDto;
import com.example.demo.Model.Dto.LivroPutDto;
import com.example.demo.Model.Entity.Livro;
import com.example.demo.Service.LivroService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroController {
    public final LivroService service;

    public LivroController(LivroService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Livro cadastrar(@RequestBody @Valid LivroPostDto livroPostDto){
        return service.adicionarLivro(livroPostDto);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Livro> buscarTodos(){
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public LivroGetDto buscarPorId(@PathVariable Long id){
        return service.buscarLivroPorIf(id).toGetDto();
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Livro editar(@PathVariable Long id, @RequestBody @Valid LivroPutDto livroPutDto){
        if (!id.equals(livroPutDto.id())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        return service.editarLivro(livroPutDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void remover(@PathVariable Long id){
        service.deletar(id);
    }
}
