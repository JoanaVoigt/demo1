package com.example.demo.Service;

import com.example.demo.Model.Dto.UsuarioPostDto;
import com.example.demo.Model.Entity.Usuario;
import com.example.demo.Repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public Usuario adicionarUsuario(UsuarioPostDto usuarioPostDto){
        return repository.save(usuarioPostDto.convert());
    }

    public List<Usuario> buscarTodos(){
        return repository.findAll();
    }

    public Usuario buscarPorId(Long id){
        return repository.findById(id).get();
    }

    public Usuario editarUsuario(Usuario usuario){
        return repository.save(usuario);
    }

    public void deletarUsuario(Long id){
        repository.deleteById(id);
    }
}
