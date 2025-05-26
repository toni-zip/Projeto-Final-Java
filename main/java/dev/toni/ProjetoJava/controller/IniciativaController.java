package dev.toni.ProjetoJava.controller;

import dev.toni.ProjetoJava.model.Iniciativa;
import dev.toni.ProjetoJava.service.IniciativaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/iniciativas")
public class IniciativaController {

    @Autowired
    private IniciativaService iniciativaService;

    @GetMapping
    public List<Iniciativa> listarTodos() {
        return iniciativaService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Iniciativa> buscarPorId(@PathVariable Long id) {
        Optional<Iniciativa> iniciativa = iniciativaService.buscarPorId(id);
        return iniciativa.map(ResponseEntity::ok)
                         .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Iniciativa> criar(@RequestBody Iniciativa iniciativa) {
        Iniciativa salvo = iniciativaService.salvar(iniciativa);
        return ResponseEntity.ok(salvo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Iniciativa> atualizar(@PathVariable Long id, @RequestBody Iniciativa nova) {
        Optional<Iniciativa> existente = iniciativaService.buscarPorId(id);
        if (existente.isPresent()) {
            Iniciativa iniciativa = existente.get();
            iniciativa.setTitulo(nova.getTitulo());
            iniciativa.setDescricao(nova.getDescricao());
            iniciativa.setPorcentagemConclusao(nova.getPorcentagemConclusao());
            iniciativa.setResultadoChave(nova.getResultadoChave());
            Iniciativa salvo = iniciativaService.salvar(iniciativa);
            return ResponseEntity.ok(salvo);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        Optional<Iniciativa> existente = iniciativaService.buscarPorId(id);
        if (existente.isPresent()) {
            iniciativaService.deletar(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
