package com.gustavoflorencio.biblioteca_api.service;

import com.gustavoflorencio.biblioteca_api.entity.Usuario;
import com.gustavoflorencio.biblioteca_api.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    // CREATE / UPDATE
    public Usuario salvar(Usuario usuario) {
        return repository.save(usuario);
    }

    // READ ALL
    public List<Usuario> listarTodos() {
        return repository.findAll();
    }

    // READ BY ID
    public Usuario buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
    }

    // DELETE
    public void deletar(Long id) {
        repository.deleteById(id);
    }
    public Usuario atualizar(Long id, Usuario usuarioAtualizado) {
    Usuario usuario = repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

    usuario.setNome(usuarioAtualizado.getNome());
    usuario.setEmail(usuarioAtualizado.getEmail());
    usuario.setSenha(usuarioAtualizado.getSenha());

    return repository.save(usuario);
}
}