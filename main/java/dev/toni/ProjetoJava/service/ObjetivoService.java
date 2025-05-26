package dev.toni.ProjetoJava.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.toni.ProjetoJava.model.Objetivo;
import dev.toni.ProjetoJava.repository.ObjetivoRepository;

@Service
public class ObjetivoService {

    @Autowired
    private ObjetivoRepository objetivoRepository;

    public List<Objetivo> listarTodos() {
        return objetivoRepository.findAll();
    }

    public Optional<Objetivo> buscarPorId(Long id) {
        return objetivoRepository.findById(id);
    }

    public Objetivo salvar(Objetivo objetivo) {
        return objetivoRepository.save(objetivo);
    }

    public void deletar(Long id) {
        objetivoRepository.deleteById(id);
    }
}
