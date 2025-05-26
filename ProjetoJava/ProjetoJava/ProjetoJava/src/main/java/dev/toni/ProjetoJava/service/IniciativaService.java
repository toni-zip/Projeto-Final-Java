package dev.toni.ProjetoJava.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.toni.ProjetoJava.model.Iniciativa;
import dev.toni.ProjetoJava.repository.IniciativaRepository;

@Service
public class IniciativaService {

    @Autowired
    private IniciativaRepository iniciativaRepository;

    public List<Iniciativa> listarTodos() {
        return iniciativaRepository.findAll();
    }

    public Optional<Iniciativa> buscarPorId(Long id) {
        return iniciativaRepository.findById(id);
    }

    public Iniciativa salvar(Iniciativa iniciativa) {
        return iniciativaRepository.save(iniciativa);
    }

    public void deletar(Long id) {
        iniciativaRepository.deleteById(id);
    }
}
