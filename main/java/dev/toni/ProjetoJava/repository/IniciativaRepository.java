package dev.toni.ProjetoJava.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.toni.ProjetoJava.model.Iniciativa;

public interface IniciativaRepository extends JpaRepository<Iniciativa, Long> {
}
