package com.gustavoflorencio.biblioteca_api.repository;

import com.gustavoflorencio.biblioteca_api.entity.Emprestimo;
import com.gustavoflorencio.biblioteca_api.entity.Livro;
import com.gustavoflorencio.biblioteca_api.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmprestimoRepository extends JpaRepository<Emprestimo, Long> {

    boolean existsByLivroAndDevolvidoFalse(Livro livro);

    long countByUsuarioAndDevolvidoFalse(Usuario usuario);
}