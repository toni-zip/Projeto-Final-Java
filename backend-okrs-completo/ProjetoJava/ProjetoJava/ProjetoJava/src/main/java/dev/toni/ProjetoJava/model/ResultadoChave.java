package dev.toni.ProjetoJava.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ResultadoChave {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;

    private String meta;

    private Double porcentagemConclusao;

    @JsonProperty("objetivo")
    @ManyToOne
    @JsonIgnoreProperties("resultadosChave")
    @JoinColumn(name = "objetivo_id")
    private Objetivo objetivo;

    @OneToMany(mappedBy = "resultadoChave", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Iniciativa> iniciativas;
}
