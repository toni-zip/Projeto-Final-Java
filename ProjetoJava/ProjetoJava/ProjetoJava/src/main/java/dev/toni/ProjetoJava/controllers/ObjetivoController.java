package dev.toni.ProjetoJava.controllers;

import dev.toni.ProjetoJava.model.Objetivo;
import dev.toni.ProjetoJava.service.ObjetivoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/objetivos")
public class ObjetivoController {

    @Autowired
    private ObjetivoService service;

    @GetMapping
    public List<Objetivo> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Objetivo> getById(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Objetivo create(@RequestBody Objetivo objetivo) {
        return service.save(objetivo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Objetivo> update(@PathVariable Long id, @RequestBody Objetivo objetivo) {
        return service.findById(id)
                .map(o -> {
                    objetivo.setId(id);
                    return ResponseEntity.ok(service.save(objetivo));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}/calcular")
    public ResponseEntity<Objetivo> calcularConclusao(@PathVariable Long id) {
        Optional<Objetivo> opt = service.findById(id);
        if (opt.isPresent()) {
            service.atualizarPercentualConclusao(opt.get());
            return ResponseEntity.ok(opt.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}