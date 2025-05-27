package dev.toni.ProjetoJava.service;

import dev.toni.ProjetoJava.model.Objetivo;
import dev.toni.ProjetoJava.model.ResultadoChave;
import dev.toni.ProjetoJava.repository.ObjetivoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        objetivo.setPorcentagemConclusao(0.0);
        return objetivoRepository.save(objetivo);
    }

    public void deletar(Long id) {
        objetivoRepository.deleteById(id);
    }

    public void atualizarPorcentagemObjetivo(Objetivo objetivo) {
        List<ResultadoChave> krs = objetivo.getResultadosChave();

        if (krs == null || krs.isEmpty()) {
            objetivo.setPorcentagemConclusao(0.0);
        } else {
            double media = krs.stream()
                    .mapToDouble(ResultadoChave::getPorcentagemConclusao)
                    .average()
                    .orElse(0.0);
            objetivo.setPorcentagemConclusao(media);
        }

        objetivoRepository.save(objetivo);
    }
}
