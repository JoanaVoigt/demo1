package com.example.demo.Repository;

import com.example.demo.Model.Entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findUsuarioById (Long id);
    Usuario findByEmail(String email);
    Usuario ExistsById(Long id);
}