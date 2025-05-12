package dev.toni.ProjetoJava.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Iniciativa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String descricao;
    private Double percentualConclusao;

    @ManyToOne
    @JoinColumn(name = "resultado_chave_id")
    private ResultadoChave resultadoChave;
}
