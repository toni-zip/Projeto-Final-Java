package dev.toni.ProjetoJava.service;

/*Henrique Totti - RA:10436584
 Antonio Pereira - RA:10436919
 Fernando Lacava - RA:10438026
 */

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.toni.ProjetoJava.model.ResultadoChave;
import dev.toni.ProjetoJava.repository.ResultadoChaveRepository;

@Service
public class ResultadoChaveService {
    public void atualizarPercentualConclusao(ResultadoChave rc) {
    if (rc.getIniciativas() != null && !rc.getIniciativas().isEmpty()) {
        double media = rc.getIniciativas().stream()
            .mapToDouble(i -> i.getPercentualConclusao() != null ? i.getPercentualConclusao() : 0.0)
            .average()
            .orElse(0.0);
        rc.setPercentualConclusao(media);
        repository.save(rc);
    }
}


    @Autowired
    private ResultadoChaveRepository repository;

    public List<ResultadoChave> findAll() {
        return repository.findAll();
    }

    public Optional<ResultadoChave> findById(Long id) {
        return repository.findById(id);
    }

    public ResultadoChave save(ResultadoChave rc) {
        return repository.save(rc);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
