package com.gustavoflorencio.biblioteca_api.controller;

import com.gustavoflorencio.biblioteca_api.entity.Usuario;
import com.gustavoflorencio.biblioteca_api.service.UsuarioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    // CREATE
    @PostMapping
    public Usuario criar(@RequestBody Usuario usuario) {
        return service.salvar(usuario);
    }

    // READ ALL
    @GetMapping
    public List<Usuario> listar() {
        return service.listarTodos();
    }

    // READ BY ID
    @GetMapping("/{id}")
    public Usuario buscar(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    // UPDATE
    @PutMapping("/{id}")
    public Usuario atualizar(@PathVariable Long id, @RequestBody Usuario usuario) {
        return service.atualizar(id, usuario);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }

}