package com.gustavoflorencio.biblioteca_api.controller;

import com.gustavoflorencio.biblioteca_api.entity.Emprestimo;
import com.gustavoflorencio.biblioteca_api.service.EmprestimoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emprestimos")
public class EmprestimoController {

    private final EmprestimoService service;

    public EmprestimoController(EmprestimoService service) {
        this.service = service;
    }

    // LISTAR EMPRÉSTIMOS
    @GetMapping
    public List<Emprestimo> listar() {
        return service.listarTodos();
    }

    // EMPRESTAR LIVRO
    @PostMapping
    public Emprestimo emprestar(@RequestParam Long usuarioId,
                                @RequestParam Long livroId) {
        return service.emprestar(usuarioId, livroId);
    }

    // DEVOLVER LIVRO
    @PutMapping("/{id}/devolver")
    public Emprestimo devolver(@PathVariable Long id) {
        return service.devolver(id);
    }
}