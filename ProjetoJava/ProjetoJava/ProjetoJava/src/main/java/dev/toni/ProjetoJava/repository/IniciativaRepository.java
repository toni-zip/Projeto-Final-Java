package dev.toni.ProjetoJava.repository;

/*Henrique Totti - RA:10436584
 Antonio Pereira - RA:10436919
 Fernando Lacava - RA:10438026
 */

import org.springframework.data.jpa.repository.JpaRepository;

import dev.toni.ProjetoJava.model.Iniciativa;

public interface IniciativaRepository extends JpaRepository<Iniciativa, Long> {
}
