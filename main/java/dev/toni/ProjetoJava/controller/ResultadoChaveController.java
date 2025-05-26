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

import dev.toni.ProjetoJava.model.ResultadoChave;
import dev.toni.ProjetoJava.service.ResultadoChaveService;

@RestController
@RequestMapping("/resultados-chave")
public class ResultadoChaveController {

    @Autowired
    private ResultadoChaveService resultadoChaveService;

    @GetMapping
    public List<ResultadoChave> listarTodos() {
        return resultadoChaveService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResultadoChave> buscarPorId(@PathVariable Long id) {
        Optional<ResultadoChave> resultado = resultadoChaveService.buscarPorId(id);
        return resultado.map(ResponseEntity::ok)
                        .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ResultadoChave> criar(@RequestBody ResultadoChave resultadoChave) {
        ResultadoChave salvo = resultadoChaveService.salvar(resultadoChave);
        return ResponseEntity.ok(salvo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResultadoChave> atualizar(@PathVariable Long id, @RequestBody ResultadoChave novo) {
        Optional<ResultadoChave> existente = resultadoChaveService.buscarPorId(id);
        if (existente.isPresent()) {
            ResultadoChave resultado = existente.get();
            resultado.setDescricao(novo.getDescricao());
            resultado.setMeta(novo.getMeta());
            resultado.setObjetivo(novo.getObjetivo());
            ResultadoChave salvo = resultadoChaveService.salvar(resultado);
            return ResponseEntity.ok(salvo);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        Optional<ResultadoChave> existente = resultadoChaveService.buscarPorId(id);
        if (existente.isPresent()) {
            resultadoChaveService.deletar(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
