package dev.toni.ProjetoJava.service;

/*Henrique Totti - RA:10436584
 Antonio Pereira - RA:10436919
 Fernando Lacava - RA:10438026
 */

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.toni.ProjetoJava.model.Iniciativa;
import dev.toni.ProjetoJava.repository.IniciativaRepository;

@Service
public class IniciativaService {

    @Autowired
    private IniciativaRepository repository;

    public List<Iniciativa> findAll() {
        return repository.findAll();
    }

    public Optional<Iniciativa> findById(Long id) {
        return repository.findById(id);
    }

    public Iniciativa save(Iniciativa iniciativa) {
        return repository.save(iniciativa);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
