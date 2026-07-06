package com.gustavoflorencio.biblioteca_api.service;

import com.gustavoflorencio.biblioteca_api.entity.Livro;
import com.gustavoflorencio.biblioteca_api.repository.LivroRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivroService {

    private final LivroRepository repository;

    public LivroService(LivroRepository repository) {
        this.repository = repository;
    }

    // CREATE / UPDATE
    public Livro salvar(Livro livro) {
        return repository.save(livro);
    }

    // READ ALL
    public List<Livro> listarTodos() {
        return repository.findAll();
    }

    // READ BY ID
    public Livro buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Livro não encontrado"));
    }

    // DELETE
    public void deletar(Long id) {
        repository.deleteById(id);
    }
    public Livro atualizar(Long id, Livro livroAtualizado) {
    Livro livro = repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Livro não encontrado"));

    livro.setTitulo(livroAtualizado.getTitulo());
    livro.setAutor(livroAtualizado.getAutor());
    livro.setAno(livroAtualizado.getAno());

    return repository.save(livro);
}
}