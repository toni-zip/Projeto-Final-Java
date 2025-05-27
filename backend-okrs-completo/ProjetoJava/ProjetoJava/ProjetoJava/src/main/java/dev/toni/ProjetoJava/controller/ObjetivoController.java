package dev.toni.ProjetoJava.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.toni.ProjetoJava.model.Objetivo;
import dev.toni.ProjetoJava.service.ObjetivoService;

@RestController
@RequestMapping("/objetivos")
public class ObjetivoController {

    @Autowired
    private ObjetivoService objetivoService;

    @GetMapping
    public List<Objetivo> listarTodos() {
        return objetivoService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Objetivo> buscarPorId(@PathVariable Long id) {
        Optional<Objetivo> objetivo = objetivoService.buscarPorId(id);
        return objetivo.map(ResponseEntity::ok)
                       .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Objetivo> criar(@RequestBody Objetivo objetivo) {
        Objetivo salvo = objetivoService.salvar(objetivo);
        return ResponseEntity.ok(salvo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Objetivo> atualizar(@PathVariable Long id, @RequestBody Objetivo objetivoAtualizado) {
        Optional<Objetivo> existente = objetivoService.buscarPorId(id);
        if (existente.isPresent()) {
            Objetivo objetivo = existente.get();
            objetivo.setTitulo(objetivoAtualizado.getTitulo());
            objetivo.setDescricao(objetivoAtualizado.getDescricao());
            Objetivo salvo = objetivoService.salvar(objetivo);
            return ResponseEntity.ok(salvo);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        Optional<Objetivo> existente = objetivoService.buscarPorId(id);
        if (existente.isPresent()) {
            objetivoService.deletar(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
