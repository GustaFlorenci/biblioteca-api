package com.gustavoflorencio.biblioteca_api.repository;

import com.gustavoflorencio.biblioteca_api.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}