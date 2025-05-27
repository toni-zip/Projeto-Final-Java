package dev.toni.ProjetoJava.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.toni.ProjetoJava.model.Objetivo;

public interface ObjetivoRepository extends JpaRepository<Objetivo, Long> {
}
