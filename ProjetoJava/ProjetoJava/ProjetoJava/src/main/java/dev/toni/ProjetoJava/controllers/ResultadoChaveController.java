package dev.toni.ProjetoJava.controllers;

/*Henrique Totti - RA:10436584
 Antonio Pereira - RA:10436919
 Fernando Lacava - RA:10438026
 */

import java.util.List;

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
    private ResultadoChaveService service;

    @GetMapping
    public List<ResultadoChave> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResultadoChave> getById(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResultadoChave create(@RequestBody ResultadoChave rc) {
        return service.save(rc);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResultadoChave> update(@PathVariable Long id, @RequestBody ResultadoChave rc) {
        return service.findById(id)
                .map(r -> {
                    rc.setId(id);
                    return ResponseEntity.ok(service.save(rc));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
