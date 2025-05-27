package dev.toni.ProjetoJava.service;

import dev.toni.ProjetoJava.model.Iniciativa;
import dev.toni.ProjetoJava.model.ResultadoChave;
import dev.toni.ProjetoJava.model.Objetivo;
import dev.toni.ProjetoJava.repository.IniciativaRepository;
import dev.toni.ProjetoJava.repository.ResultadoChaveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IniciativaService {

    @Autowired
    private IniciativaRepository iniciativaRepository;

    @Autowired
    private ResultadoChaveRepository resultadoChaveRepository;

    @Autowired
    private ObjetivoService objetivoService;

    public List<Iniciativa> listarTodos() {
        return iniciativaRepository.findAll();
    }

    public Optional<Iniciativa> buscarPorId(Long id) {
        return iniciativaRepository.findById(id);
    }

    public Iniciativa salvar(Iniciativa iniciativa) {
        if (iniciativa.getResultadoChave() != null && iniciativa.getResultadoChave().getId() != null) {
            Long krId = iniciativa.getResultadoChave().getId();
            resultadoChaveRepository.findById(krId).ifPresent(iniciativa::setResultadoChave);
        }

        Iniciativa salva = iniciativaRepository.save(iniciativa);

        ResultadoChave resultadoChave = salva.getResultadoChave();
        atualizarPorcentagemKR(resultadoChave);

        return salva;
    }

    public void deletar(Long id) {
        Optional<Iniciativa> iniciativaOpt = iniciativaRepository.findById(id);

        if (iniciativaOpt.isPresent()) {
            Iniciativa iniciativa = iniciativaOpt.get();
            ResultadoChave kr = iniciativa.getResultadoChave();
            iniciativaRepository.deleteById(id);
            atualizarPorcentagemKR(kr);
        }
    }

    private void atualizarPorcentagemKR(ResultadoChave kr) {
        ResultadoChave krCompleto = resultadoChaveRepository.findById(kr.getId()).orElse(null);
        if (krCompleto == null) return;

        List<Iniciativa> iniciativas = krCompleto.getIniciativas();

        if (iniciativas == null || iniciativas.isEmpty()) {
            krCompleto.setPorcentagemConclusao(0.0);
        } else {
            double media = iniciativas.stream()
                    .mapToDouble(Iniciativa::getPorcentagemConclusao)
                    .average()
                    .orElse(0.0);
            krCompleto.setPorcentagemConclusao(media);
        }

        resultadoChaveRepository.save(krCompleto);

        Objetivo objetivo = krCompleto.getObjetivo();
        if (objetivo != null) {
            objetivoService.atualizarPorcentagemObjetivo(objetivo);
        }
    }
}
