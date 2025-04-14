package com.example.demo.Controller;

import com.example.demo.Model.Dto.UsuarioGetDto;
import com.example.demo.Model.Dto.UsuarioPostDto;
import com.example.demo.Model.Entity.Livro;
import com.example.demo.Model.Entity.Usuario;
import com.example.demo.Service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    private final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario adicionar (@RequestBody @Valid UsuarioPostDto usuarioPostDto){
        return service.adicionarUsuario(usuarioPostDto);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Usuario> buscarTodos(){
        return service.buscarTodos();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UsuarioGetDto buscarPorId(@PathVariable Long id){
        return service.buscarPorId(id).toGetDto();
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public Usuario editar( @RequestBody Usuario usuario){
        return service.editarUsuario(usuario);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deletar(@PathVariable Long id){
        service.deletarUsuario(id);
    }
}
