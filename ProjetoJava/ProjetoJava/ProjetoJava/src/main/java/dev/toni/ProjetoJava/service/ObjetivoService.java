package dev.toni.ProjetoJava.service;

/*Henrique Totti - RA:10436584
 Antonio Pereira - RA:10436919
 Fernando Lacava - RA:10438026
 */

import dev.toni.ProjetoJava.model.Objetivo;
import dev.toni.ProjetoJava.repository.ObjetivoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ObjetivoService {

    @Autowired
    private ObjetivoRepository repository;

    @Autowired
private ResultadoChaveService resultadoChaveService;

public void atualizarPercentualConclusao(Objetivo obj) {
    if (obj.getResultadosChave() != null && !obj.getResultadosChave().isEmpty()) {
        obj.getResultadosChave().forEach(resultadoChaveService::atualizarPercentualConclusao);

        double media = obj.getResultadosChave().stream()
            .mapToDouble(rc -> rc.getPercentualConclusao() != null ? rc.getPercentualConclusao() : 0.0)
            .average()
            .orElse(0.0);
        obj.setPercentualConclusao(media);
        repository.save(obj);
    }
}


    public List<Objetivo> findAll() {
        return repository.findAll();
    }

    public Optional<Objetivo> findById(Long id) {
        return repository.findById(id);
    }

    public Objetivo save(Objetivo objetivo) {
        return repository.save(objetivo);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
