package dev.toni.ProjetoJava.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Objetivo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    private String descricao;

    private Double porcentagemConclusao;

    @OneToMany(mappedBy = "objetivo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ResultadoChave> resultadosChave;
}
