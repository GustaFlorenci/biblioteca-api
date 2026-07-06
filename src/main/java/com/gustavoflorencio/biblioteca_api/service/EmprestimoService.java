package com.gustavoflorencio.biblioteca_api.service;

import com.gustavoflorencio.biblioteca_api.entity.Emprestimo;
import com.gustavoflorencio.biblioteca_api.entity.Livro;
import com.gustavoflorencio.biblioteca_api.entity.Usuario;
import com.gustavoflorencio.biblioteca_api.repository.EmprestimoRepository;
import com.gustavoflorencio.biblioteca_api.repository.LivroRepository;
import com.gustavoflorencio.biblioteca_api.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class EmprestimoService {

    private final LivroRepository livroRepository;
    private final UsuarioRepository usuarioRepository;
    private final EmprestimoRepository emprestimoRepository;

    public EmprestimoService(LivroRepository livroRepository,
                             UsuarioRepository usuarioRepository,
                             EmprestimoRepository emprestimoRepository) {
        this.livroRepository = livroRepository;
        this.usuarioRepository = usuarioRepository;
        this.emprestimoRepository = emprestimoRepository;
    }

    public List<Emprestimo> listarTodos() {
        return emprestimoRepository.findAll();
    }

    public Emprestimo emprestar(Long usuarioId, Long livroId) {
        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        Livro livro = livroRepository.findById(livroId)
                .orElseThrow(() -> new RuntimeException("Livro não encontrado"));

        boolean livroEmprestado = emprestimoRepository.existsByLivroAndDevolvidoFalse(livro);

        if (livroEmprestado) {
            throw new RuntimeException("Livro já está emprestado");
        }

        long emprestimosAtivos = emprestimoRepository.countByUsuarioAndDevolvidoFalse(usuario);

        if (emprestimosAtivos >= 3) {
            throw new RuntimeException("Usuário já possui 3 empréstimos ativos");
        }

        Emprestimo emprestimo = new Emprestimo();
        emprestimo.setUsuario(usuario);
        emprestimo.setLivro(livro);
        emprestimo.setDataEmprestimo(LocalDate.now());
        emprestimo.setDevolvido(false);

        return emprestimoRepository.save(emprestimo);
    }

    public Emprestimo devolver(Long emprestimoId) {
        Emprestimo emprestimo = emprestimoRepository.findById(emprestimoId)
                .orElseThrow(() -> new RuntimeException("Empréstimo não encontrado"));

        emprestimo.setDevolvido(true);
        emprestimo.setDataDevolucao(LocalDate.now());

        return emprestimoRepository.save(emprestimo);
    }
}