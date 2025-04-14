package com.example.demo.Controller;

import com.example.demo.Model.Dto.EmprestimoGetDto;
import com.example.demo.Model.Dto.EmprestimoPostDto;
import com.example.demo.Model.Dto.EmprestimoPutDto;
import com.example.demo.Model.Entity.Emprestimo;
import com.example.demo.Service.EmprestimoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/emprestimos")
public class EmprestimoController {
    private final EmprestimoService service;

    public EmprestimoController(EmprestimoService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Emprestimo criar(@RequestBody @Valid EmprestimoPostDto emprestimoPostDto) {
        return service.adicionarEmprestimo(emprestimoPostDto);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Emprestimo> buscarTodos() {
        return service.buscarTodos();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public EmprestimoGetDto buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id).toGetDto();
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Emprestimo editar(@PathVariable Long id, @RequestBody @Valid EmprestimoPutDto emprestimoPutDto) {
        if (!id.equals(emprestimoPutDto.id())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        return service.editar(emprestimoPutDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}
