package dev.toni.ProjetoJava.service;

import dev.toni.ProjetoJava.model.ResultadoChave;
import dev.toni.ProjetoJava.model.Objetivo;
import dev.toni.ProjetoJava.repository.ResultadoChaveRepository;
import dev.toni.ProjetoJava.repository.ObjetivoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResultadoChaveService {

    @Autowired
    private ResultadoChaveRepository resultadoChaveRepository;

    @Autowired
    private ObjetivoRepository objetivoRepository;

    @Autowired
    private ObjetivoService objetivoService;

    public List<ResultadoChave> listarTodos() {
        return resultadoChaveRepository.findAll();
    }

    public Optional<ResultadoChave> buscarPorId(Long id) {
        return resultadoChaveRepository.findById(id);
    }

    public ResultadoChave salvar(ResultadoChave kr) {
        // Corrige associação com objetivo
        if (kr.getObjetivo() != null && kr.getObjetivo().getId() != null) {
            Long objetivoId = kr.getObjetivo().getId();
            objetivoRepository.findById(objetivoId).ifPresent(kr::setObjetivo);
        }

        ResultadoChave salvo = resultadoChaveRepository.save(kr);

        Objetivo objetivo = salvo.getObjetivo();
        if (objetivo != null) {
            objetivoService.atualizarPorcentagemObjetivo(objetivo);
        }

        return salvo;
    }

    public void deletar(Long id) {
        Optional<ResultadoChave> opt = resultadoChaveRepository.findById(id);

        if (opt.isPresent()) {
            ResultadoChave kr = opt.get();
            Objetivo objetivo = kr.getObjetivo();

            resultadoChaveRepository.deleteById(id);

            if (objetivo != null) {
                objetivoService.atualizarPorcentagemObjetivo(objetivo);
            }
        }
    }
}
