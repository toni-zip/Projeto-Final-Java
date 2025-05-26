package dev.toni.ProjetoJava.service;

import dev.toni.ProjetoJava.model.ResultadoChave;
import dev.toni.ProjetoJava.repository.ResultadoChaveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResultadoChaveService {

    @Autowired
    private ResultadoChaveRepository resultadoChaveRepository;

    public List<ResultadoChave> listarTodos() {
        return resultadoChaveRepository.findAll();
    }

    public Optional<ResultadoChave> buscarPorId(Long id) {
        return resultadoChaveRepository.findById(id);
    }

    public ResultadoChave salvar(ResultadoChave rc) {
        return resultadoChaveRepository.save(rc);
    }

    public void deletar(Long id) {
        resultadoChaveRepository.deleteById(id);
    }
}
