package com.gustavoflorencio.biblioteca_api.repository;

import com.gustavoflorencio.biblioteca_api.entity.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Long> {
}