package com.example.demo.Service;

import com.example.demo.Model.Entity.Editora;
import com.example.demo.Repository.EditoraRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EditoraService {
    private final EditoraRepository repository;

    public EditoraService(EditoraRepository repository) {
        this.repository = repository;
    }

    public Editora adicionarEditora(Editora editora){
        return repository.save(editora);
    }

    public List<Editora> buscarTodos(){
        return repository.findAll();
    }

    public Editora buscarPorId(Long id){
        return repository.findById(id).get();
    }

    public Editora editar(Editora editora){
        return repository.save(editora);
    }

    public void deletar(Long id){
        repository.deleteById(id);
    }
}
