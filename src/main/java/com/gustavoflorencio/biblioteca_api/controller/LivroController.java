package com.gustavoflorencio.biblioteca_api.controller;

import com.gustavoflorencio.biblioteca_api.entity.Livro;
import com.gustavoflorencio.biblioteca_api.service.LivroService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroController {

    private final LivroService service;

    public LivroController(LivroService service) {
        this.service = service;
    }

    // CREATE
    @PostMapping
    public Livro criar(@RequestBody Livro livro) {
        return service.salvar(livro);
    }

    // READ ALL
    @GetMapping
    public List<Livro> listar() {
        return service.listarTodos();
    }

    // READ BY ID
    @GetMapping("/{id}")
    public Livro buscar(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    // UPDATE
    @PutMapping("/{id}")
    public Livro atualizar(@PathVariable Long id, @RequestBody Livro livro) {
        livro.setId(id);
        return service.salvar(livro);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }

}